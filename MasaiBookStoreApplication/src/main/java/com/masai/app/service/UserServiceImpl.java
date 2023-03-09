package com.masai.app.service;

import com.masai.app.exception.UserException;
import com.masai.app.model.Book;
import com.masai.app.model.Cart;
import com.masai.app.model.User;
import com.masai.app.repository.BookDao;
import com.masai.app.repository.CartDao;
import com.masai.app.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public String registerUser(User user) throws UserException {
        String res = "User registration unsuccessful";

        if (userDao.existsByMobileNumber(user.getMobileNumber())) {
            throw new UserException("Username is already taken");
        }

        //creating user account
        userDao.save(user);

        //creating cart for the user

        Cart cart = new Cart();
        cart.setUser(user);
        cartDao.save(cart);

        if (userDao.existsById(user.getUserId())) {
            res = "User registered successfully";
        } else {
            throw new UserException("Failed to register user");
        }


        return res;
    }

    @Override
    public User loginUser(User user) throws UserException {
        User existingUser = userDao.findByMobileNumber(user.getMobileNumber());
        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            throw new UserException("Invalid username or password.");
        }
        return existingUser;
    }

    @Override
    public String addToCart(int userId, int bookId) throws UserException {

        String res = "Add succussfully";
        User user = userDao.findById(userId).orElseThrow(() -> new UserException("User not found."));
        Book book = bookDao.findById(bookId).orElseThrow(() -> new UserException("Book not found."));

        if (user.getCart().equals(book)) {
            throw new UserException("Book already in cart.");
            res = "Add not succuessfully";
            return res;
        }

        List<Book> updatedCart = new ArrayList<>(user.getCart().getBooks());
        updatedCart.add(book);
        userDao.save(user.setCart(updatedCart));
        return res;
    }


}

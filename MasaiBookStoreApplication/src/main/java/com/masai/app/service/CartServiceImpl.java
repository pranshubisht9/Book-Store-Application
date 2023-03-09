package com.masai.app.service;

import com.masai.app.exception.BookException;
import com.masai.app.exception.CartException;
import com.masai.app.exception.UserException;
import com.masai.app.model.Book;
import com.masai.app.model.Cart;
import com.masai.app.model.User;
import com.masai.app.repository.BookDao;
import com.masai.app.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public User purchaseCart(User user) throws UserException {
        User loggedInUser = userDao.findById(user.getUserId()).orElseThrow(() -> new UserException("User not found"));

        List<Book> cart = (List<Book>) loggedInUser.getCart();
        double totalCost = 0;

        for (Book book : cart) {
            totalCost += book.getPrice();
        }

        if (loggedInUser.getBudget() < totalCost) {
            throw new UserException("Insufficient funds.");
        }

        loggedInUser.setBudget((int) (loggedInUser.getBudget() - totalCost));

        userDao.save(loggedInUser);

        return loggedInUser;
    }

    @Override
    public User refreshCart(User user) throws UserException {
        User loggedInUser = userDao.findById(user.getUserId()).orElseThrow(() -> new UserException("User not found"));

        List<Book> cart = (List<Book>) loggedInUser.getCart();

        List<Book> updatedCart = new ArrayList<>();

        for (Book book : cart) {
            if (book.getDateAdded().plusDays(30).isBefore(LocalDate.now())) {
            } else {
                updatedCart.add(book);
            }
        }

        loggedInUser.setCart((Cart) updatedCart);

        userDao.save(loggedInUser);

        return loggedInUser;
    }

    @Override
    public List<Book> mostNumberOfBooks() throws BookException, CartException {

        List<Book> list =  bookDao.;

        List<Student> students=

        if(students.isEmpty())
            throw new StudentException("No student found..");

        return students;

    }
}

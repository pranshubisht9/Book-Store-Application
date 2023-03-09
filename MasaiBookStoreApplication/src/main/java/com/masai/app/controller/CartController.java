package com.masai.app.controller;

import com.masai.app.exception.BookException;
import com.masai.app.exception.CartException;
import com.masai.app.exception.UserException;
import com.masai.app.model.Book;
import com.masai.app.model.User;
import com.masai.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/masaibook")
public class CartController {

    @Autowired
    private CartService service;

    // purhchase cart handler
    @PutMapping("user/cart/purchase")
    public ResponseEntity<User> purchaseCartHanlder(User user) throws UserException {
        User res = service.purchaseCart(user);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //most number of books
    @PutMapping("/user/cart/auto")
    public ResponseEntity<List<Book>> mostNumberOfBooksHandler() throws BookException, CartException{

        List<Book> res = service.mostNumberOfBooks();

        return new ResponseEntity<>(res, HttpStatus.OK);

    }



}

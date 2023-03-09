package com.masai.app.service;

import com.masai.app.exception.BookException;
import com.masai.app.exception.CartException;
import com.masai.app.exception.UserException;
import com.masai.app.model.Book;
import com.masai.app.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CartService {

    public User purchaseCart(User user) throws UserException;

    public User refreshCart(User user) throws UserException;

    public List<Book> mostNumberOfBooks() throws BookException, CartException;

}

package com.masai.app.controller;

import com.masai.app.exception.BookException;
import com.masai.app.exception.UserException;
import com.masai.app.model.Book;
import com.masai.app.model.User;
import com.masai.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/masaibook")
public class BookController {

    @Autowired
    private BookService service;

    //register book
    @PostMapping("/register/user")
    public ResponseEntity<String> registerUserHandler(@RequestBody Book book) throws  BookException {
        String res = service.registerBook(book);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}

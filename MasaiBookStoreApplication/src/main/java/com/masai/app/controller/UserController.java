package com.masai.app.controller;

import com.masai.app.exception.UserException;
import com.masai.app.model.User;
import com.masai.app.repository.UserDao;
import com.masai.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masaibook")
public class UserController {

    @Autowired
    private UserService service;

    //register user
    @PostMapping("/register/user")
    public ResponseEntity<String> registerUserHandler(@RequestBody User user) throws UserException{
        String res = service.registerUser(user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    // login user
    @PostMapping("/user/login")
    public ResponseEntity<User> loginUserHandler(@RequestBody User user) throws UserException{
       User res = service.loginUser(user);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // Add a book to logged in user’s cart only if the book is not present already

    @PutMapping("/masaibook/user/cart/{bookId}/{userId}")
    public ResponseEntity<String> addToCartHanlder(@PathVariable("userId") int userId,@PathVariable("bookId") int bookId) throws UserException{
        String res = service.addToCart(userId, bookId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }




}

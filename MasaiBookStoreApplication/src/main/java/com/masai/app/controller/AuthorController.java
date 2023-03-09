package com.masai.app.controller;

import com.masai.app.exception.AuthorException;
import com.masai.app.exception.BookException;
import com.masai.app.exception.UserException;
import com.masai.app.model.Author;
import com.masai.app.model.User;
import com.masai.app.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masaibook")
public class AuthorController {
    @Autowired
    private AuthorService service;

    //register Author
    @PostMapping("/register/author")
    public ResponseEntity<String> registerAuthorHandler(@RequestBody Author author) throws AuthorException {
        String res = service.registerAuthor(author);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    //get Most Popular Author
    @GetMapping("/author")
    public ResponseEntity<Author> getMostPopularAuthorHandler() throws BookException{
        Author res = service.getMostPopularAuthor();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // delete an author
    @GetMapping("/author/{authorId}")
    public ResponseEntity<Author> deleteAuthorHandler(@PathVariable("authorId") Integer id) throws AuthorException {
        Author res = service.deleteAuthor(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}

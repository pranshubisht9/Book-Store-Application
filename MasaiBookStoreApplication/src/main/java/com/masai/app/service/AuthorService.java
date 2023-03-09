package com.masai.app.service;

import com.masai.app.exception.AuthorException;
import com.masai.app.exception.BookException;
import com.masai.app.model.Author;
import com.masai.app.model.Book;

public interface AuthorService {
    public String registerAuthor(Author author) throws AuthorException;
    public Author getMostPopularAuthor() throws BookException;

    public Author deleteAuthor(Integer authorId) throws AuthorException;
}

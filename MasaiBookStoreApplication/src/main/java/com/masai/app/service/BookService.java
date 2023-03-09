package com.masai.app.service;

import com.masai.app.exception.BookException;
import com.masai.app.exception.UserException;
import com.masai.app.model.Book;
import com.masai.app.model.User;

public interface BookService {
    public String registerBook(Book book) throws BookException;

}

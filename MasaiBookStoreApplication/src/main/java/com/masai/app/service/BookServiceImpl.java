package com.masai.app.service;

import com.masai.app.exception.BookException;
import com.masai.app.model.Author;
import com.masai.app.model.Book;
import com.masai.app.model.Cart;
import com.masai.app.repository.AuthorDao;
import com.masai.app.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Override
    public String registerBook(Book book) throws BookException {

        String res = "Register unsuccessfully";
        Author author = book.getAuthor();

        if (authorDao.existsByName(author.getName())) {
            author = authorDao.findByName(author.getName());
        } else {
            authorDao.save(author);
        }

        book.setAuthor(author);
        bookDao.save(book);

        if (bookDao.existsById(book.getBookId())) {
            res = "Register successfully";
        } else {
            throw new BookException("Failed to register book");
        }

        return res;

    }

}

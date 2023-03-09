package com.masai.app.service;

import com.masai.app.exception.AuthorException;
import com.masai.app.exception.BookException;
import com.masai.app.model.Author;
import com.masai.app.model.Book;
import com.masai.app.repository.AuthorDao;
import com.masai.app.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements  AuthorService{

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public String registerAuthor(Author author) throws AuthorException {
        String res = "Author registration unsuccessful";

        if (authorDao.existsByName(author.getName())) {
            throw new AuthorException("Author with name " + author.getName() + " already exists");
        }

        authorDao.save(author);

        if (authorDao.existsById(author.getAuthorId())) {
            res = "Author registration successful";
        } else {
            throw new AuthorException("Failed to register author");
        }

        return res;
    }

    @Override
    public Author getMostPopularAuthor() throws BookException {
        List<Book> books = bookDao.findAll();
        Map<Author, Integer> authorCounts = new HashMap<>();

        for (Book book : books) {
            Author author = book.getAuthor();
            if (authorCounts.containsKey(author)) {
                authorCounts.put(author, authorCounts.get(author) + 1);
            } else {
                authorCounts.put(author, 1);
            }
        }

        Author mostPopularAuthor = null;
        int maxCount = 0;

        for (Map.Entry<Author, Integer> entry : authorCounts.entrySet()) {
            Author author = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount) {
                mostPopularAuthor = author;
                maxCount = count;
            }
        }

        if (mostPopularAuthor == null) {
            throw new BookException("No authors found.");
        }

        return mostPopularAuthor;
    }

    @Override
    public Author deleteAuthor(Integer authorId) throws AuthorException {
        Optional<Author> opt= authorDao.findById(authorId);

        if(opt.isPresent()) {

            Author author = opt.get();

            authorDao.delete(author);

            return author;

        }
        else
            throw new AuthorException("Author does not exist with Id :"+authorId);
    }
}

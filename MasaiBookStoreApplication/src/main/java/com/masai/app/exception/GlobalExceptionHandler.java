package com.masai.masaiatmapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // for user exception

    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException ae, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ae.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    // for book exception

    @ExceptionHandler(BookException.class)
    public ResponseEntity<MyErrorDetails> bookExceptionHandler(BookException ae, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ae.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    // for cart exception

    @ExceptionHandler(CartException.class)
    public ResponseEntity<MyErrorDetails> cartExceptionHandler(CartException ae, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ae.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    // for author exception

    @ExceptionHandler(AuthorException.class)
    public ResponseEntity<MyErrorDetails> authorExceptionHandler(AuthorException ae, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ae.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    // for generic type exception

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> genericExceptionHandler(Exception ae, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ae.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    // for no handler found exception

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> myexpHandler4(NoHandlerFoundException ae, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ae.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    // for method argument not valid exception

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
        MyErrorDetails err = new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setDetails("Validation Error");
        err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

}
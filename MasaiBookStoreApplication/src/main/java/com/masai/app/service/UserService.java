package com.masai.app.service;

import com.masai.app.exception.UserException;
import com.masai.app.model.User;

public interface UserService {
    public String registerUser(User user) throws UserException;
    public User loginUser(User user) throws UserException;

   public String addToCart(int userId, int bookId) throws UserException;

}

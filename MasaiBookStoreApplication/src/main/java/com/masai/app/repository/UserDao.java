package com.masai.app.repository;

import com.masai.app.exception.UserException;
import com.masai.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    boolean existsByMobileNumber(String mobileNumber);
    public User findByMobileNumber(String mobileNumber);

    public void purchaseCart(User user) throws UserException;
}

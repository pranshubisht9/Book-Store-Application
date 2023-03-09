package com.masai.app.repository;

import com.masai.app.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
}

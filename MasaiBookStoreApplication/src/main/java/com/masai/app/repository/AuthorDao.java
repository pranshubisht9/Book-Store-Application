package com.masai.app.repository;

import com.masai.app.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
    boolean existsByName(String name);

    @Query("SELECT a FROM Author a WHERE a.name = :name")
    Author findByName(@Param("name") String name);

}

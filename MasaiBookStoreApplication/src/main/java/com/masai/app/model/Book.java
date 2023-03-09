package com.masai.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private String name;
    private Integer pages;
    private String publisher;
    private Integer price;
    private LocalDate dateAdded;
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    @ManyToOne
    private Cart cart;

    public LocalDate getDateAdded() {

        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}

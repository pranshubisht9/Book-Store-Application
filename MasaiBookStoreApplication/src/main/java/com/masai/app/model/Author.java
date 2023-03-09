package com.masai.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorId;
    private String name;
    private String mobileNo;
    private String address;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> allBooks;
}

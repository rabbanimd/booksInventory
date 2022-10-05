package com.cortes.books.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String bookName;
    @Column(name = "author_name")
    private String authorName;

    @Column(name = "ISBN")
    private String ISBN;
    @Column(name = "pages")
    private Integer pages;
    @Column(name = "description")
    private String description;

}

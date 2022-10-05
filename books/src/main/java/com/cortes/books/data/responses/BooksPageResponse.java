package com.cortes.books.data.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksPageResponse {
    private Long id;
    private String bookName;
    private String authorName;
    private String ISBN;
    private int pages;
    private String description;
}

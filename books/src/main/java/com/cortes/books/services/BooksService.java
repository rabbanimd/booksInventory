package com.cortes.books.services;

import com.cortes.books.data.responses.BooksPageResponse;
import com.cortes.books.data.responses.BooksPageResponsePaged;
import org.springframework.data.domain.Pageable;

public interface BooksService {
    BooksPageResponse getBookById(Long id);
    BooksPageResponsePaged getBooksByName(int pageNo,int pageSize, String bookName);
    BooksPageResponsePaged getBooksByAuthor(int pageNo,int pageSize, String authorName);
    BooksPageResponsePaged getBooksList(int pageNo,int pageSize);
}

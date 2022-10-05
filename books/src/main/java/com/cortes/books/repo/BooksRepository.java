package com.cortes.books.repo;

import com.cortes.books.data.models.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
    Page<Books> findByBookNameContaining(String bookName, Pageable pagedRecords);

    Page<Books> findByAuthorNameContaining(String authorName, Pageable pagedRecords);
}

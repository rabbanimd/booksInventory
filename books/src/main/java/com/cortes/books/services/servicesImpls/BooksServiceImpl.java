package com.cortes.books.services.servicesImpls;

import com.cortes.books.data.models.Books;
import com.cortes.books.data.responses.BooksPageResponse;
import com.cortes.books.data.responses.BooksPageResponsePaged;
import com.cortes.books.repo.BooksRepository;
import com.cortes.books.resolve.exceptions.ResourceNotFoundException;
import com.cortes.books.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Override
    public BooksPageResponse getBookById(Long id) {
        return bookToBooksPageReponse(booksRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Book","id", id.toString())));
    }

    @Override
    public BooksPageResponsePaged getBooksByName(int pageNo,int pageSize, String bookName) {
        Pageable pagedRecords = PageRequest.of(pageNo, pageSize);
        Page<Books> booksPage = booksRepository.findByBookNameContaining(bookName, pagedRecords);
        if(booksPage.isEmpty())throw new ResourceNotFoundException("Books","bookName",bookName);
        return booksToBooksPageResponsePaged(booksPage);
    }

    @Override
    public BooksPageResponsePaged getBooksByAuthor(int pageNo,int pageSize, String authorName) {
        Pageable pagedRecords = PageRequest.of(pageNo, pageSize);
        Page<Books> booksPage = booksRepository.findByAuthorNameContaining(authorName,
                pagedRecords);
        if(booksPage.isEmpty())throw new ResourceNotFoundException("Books","authorName",authorName);
        return booksToBooksPageResponsePaged(booksPage);
    }

    @Override
    public BooksPageResponsePaged getBooksList(int pageNo,int pageSize) {
        Pageable pagedRecords = PageRequest.of(pageNo, pageSize);
        Page<Books> booksPage = booksRepository.findAll(pagedRecords);
        return booksToBooksPageResponsePaged(booksPage);
    }
    private BooksPageResponse bookToBooksPageReponse(Books book) {
        return new BooksPageResponse(book.getId(),
                book.getBookName(),
                book.getAuthorName(),
                book.getISBN(),
                book.getPages(),
                book.getDescription());

    }
    private BooksPageResponsePaged booksToBooksPageResponsePaged(Page page) {
        return new BooksPageResponsePaged(
                page.getNumber(),
                page.getNumberOfElements(),
                page.getTotalPages(),
                page.isLast(),
                page.getContent().stream().toList()
        );
    }
}

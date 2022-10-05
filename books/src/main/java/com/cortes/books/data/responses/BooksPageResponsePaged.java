package com.cortes.books.data.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BooksPageResponsePaged {
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private Boolean isLast;
    List<BooksPageResponse> books = new ArrayList<>();
}

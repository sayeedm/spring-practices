package com.impostercorp.practices.spring.elastic.services;

import com.impostercorp.practices.spring.elastic.models.Book;

import java.util.List;

public interface BooksService {
    List<Book> searchByTitleOrSummary(String query);
    List<Book> searchByTitle(String query);
    List<Book> summaryBoostedSearch(String query);
    List<Book> searchWithAuthorFilter(String [] titles, String byAuthor, String excludeAuthor);
}

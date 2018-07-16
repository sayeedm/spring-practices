package com.impostercorp.practices.spring.elastic.services;


import com.impostercorp.practices.spring.elastic.daos.BooksDao;
import com.impostercorp.practices.spring.elastic.models.Book;
import com.impostercorp.practices.spring.elastic.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings({ "unused", "WeakerAccess" })
@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRepository repository;

    @Autowired
    BooksDao dao;

    @Override
    public List<Book> searchByTitleOrSummary(String query) {
        return dao.searchByTitleOrSummary(query);
    }

    @Override
    public List<Book> searchByTitle(String query) {
        return dao.searchByTitle(query);
    }

    @Override
    public List<Book> summaryBoostedSearch(String query) {
        return dao.summaryBoostedSearch(query);
    }

    @Override
    public List<Book> searchWithAuthorFilter(String[] titles, String byAuthor, String excludeAuthor) {
        return dao.searchWithAuthorFilter(titles, byAuthor, excludeAuthor);
    }
}

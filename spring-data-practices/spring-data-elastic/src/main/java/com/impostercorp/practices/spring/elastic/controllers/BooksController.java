package com.impostercorp.practices.spring.elastic.controllers;

import com.impostercorp.practices.spring.elastic.models.Book;
import com.impostercorp.practices.spring.elastic.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is for demonstration purpose - We are testing elastic search query builder and elastic search operations
 * Intentionally standard endpoints to given
 *
 * Author: SayeedM
 */

@SuppressWarnings({ "unused", "WeakerAccess" })
@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    BooksService service;

    @RequestMapping(method = RequestMethod.GET, value = "/searchByTitleOrSummary")
    public List<Book> searchByTitleOrSummary(@RequestParam("q") String query){
        return service.searchByTitleOrSummary(query);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchByTitle")
    public List<Book> searchByTitle(@RequestParam("q") String query){
        return service.searchByTitle(query);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/summaryBoostedSearch")
    public List<Book> summaryBoostedSearch(@RequestParam("q") String query){
        return service.summaryBoostedSearch(query);
    }

    @RequestMapping(method = RequestMethod.GET, value="/searchWithAuthorFilter")
    List<Book> searchWithAuthorFilter(@RequestParam("titles") String [] titles,
                                      @RequestParam("byAuthor") String byAuthor,
                                      @RequestParam("excludeAuthor") String excludeAuthor){
        return service.searchWithAuthorFilter(titles, byAuthor, excludeAuthor);
    }


}

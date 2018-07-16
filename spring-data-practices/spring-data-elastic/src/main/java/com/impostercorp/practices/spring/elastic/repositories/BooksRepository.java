package com.impostercorp.practices.spring.elastic.repositories;

import com.impostercorp.practices.spring.elastic.models.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends ElasticsearchRepository<Book, Long> {
}

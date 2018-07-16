package com.impostercorp.practices.spring.elastic.daos;

import com.impostercorp.practices.spring.elastic.models.Book;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;
import static org.elasticsearch.index.query.QueryBuilders.boolQuery;


@SuppressWarnings({ "WeakerAccess" })
@Component
public class BooksDao {

    @Autowired
    ElasticsearchOperations template;

    public List<Book> searchByTitleOrSummary(String query){
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                                        .withQuery(multiMatchQuery(query, "title", "summary"))
                                        .build();
        return template.queryForList(searchQuery, Book.class);
    }

    public List<Book> searchByTitle(String query){
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("title", query)).build();
        return template.queryForList(searchQuery, Book.class);
    }

    public List<Book> summaryBoostedSearch(String query){
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(multiMatchQuery(query, "title", "summary").field("summary", 3))
                .build();

        return template.queryForList(searchQuery, Book.class);

    }

    public List<Book> searchWithAuthorFilter(String [] titles, String byAuthor, String excludeAuthor){
        BoolQueryBuilder boolQuery = boolQuery();
        for (String s : titles)
            boolQuery.should(matchQuery("title", s));
        boolQuery.must(matchQuery("authors", byAuthor));
        boolQuery.mustNot(matchQuery("authors", excludeAuthor));
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(boolQuery().must(boolQuery)).build();
        return template.queryForList(searchQuery, Book.class);
    }
}

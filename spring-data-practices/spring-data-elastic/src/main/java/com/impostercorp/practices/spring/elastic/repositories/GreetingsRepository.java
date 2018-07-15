package com.impostercorp.practices.spring.elastic.repositories;

import com.impostercorp.practices.spring.elastic.models.Greeting;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface GreetingsRepository extends ElasticsearchRepository<Greeting, String> {

    List<Greeting> findByUsername(String username);

}

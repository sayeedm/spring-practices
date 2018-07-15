package com.impostercorp.practices.spring.elastic.services;

import com.impostercorp.practices.spring.elastic.models.Greeting;
import java.util.List;

@SuppressWarnings("unused")
public interface GreetingsService {

    List<Greeting> getAll();
    Greeting findOne(String id);
    Greeting create(Greeting greeting);
    Greeting update(Greeting greeting);
    List<Greeting> getGreetingByUsername(String username);
    void delete(String id);

}

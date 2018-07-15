package com.impostercorp.practices.spring.elastic.services;

import com.impostercorp.practices.spring.elastic.models.Greeting;
import com.impostercorp.practices.spring.elastic.repositories.GreetingsRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings({ "unused", "WeakerAccess" })
@Service
public class GreetingServiceImpl implements GreetingsService {

    @Autowired
    GreetingsRepository repository;

    @Override
    public List<Greeting> getAll() {
        List<Greeting> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Greeting findOne(String id) {
        Optional<Greeting> greeting = repository.findById(id);
        return greeting.isPresent() ? greeting.get() : null;
    }

    @Override
    public Greeting create(Greeting greeting) {
        return repository.save(greeting);
    }

    @Override
    public Greeting update(Greeting greeting) {
        return repository.save(greeting);
    }

    @Override
    public List<Greeting> getGreetingByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

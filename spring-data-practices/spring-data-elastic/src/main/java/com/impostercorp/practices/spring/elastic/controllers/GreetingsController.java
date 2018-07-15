package com.impostercorp.practices.spring.elastic.controllers;

import com.impostercorp.practices.spring.elastic.models.Greeting;
import com.impostercorp.practices.spring.elastic.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api")
public class GreetingsController {

    @Autowired
    private GreetingsService greetingService;

    @ResponseBody
    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public ResponseEntity<List<Greeting>> getAll() {
        return new ResponseEntity<>(greetingService.getAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/greetings", method = RequestMethod.POST)
    public ResponseEntity<Greeting> insertGreeting(@RequestBody Greeting greeting) {
        return new ResponseEntity<>(greetingService.create(greeting), HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/greetings", method = RequestMethod.PUT)
    public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting greeting) {
        return new ResponseEntity<>(greetingService.update(greeting), HttpStatus.MOVED_PERMANENTLY);
    }

    @ResponseBody
    @RequestMapping(value = "/greetings/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") String idd) {
        greetingService.delete(idd);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ResponseBody
    @RequestMapping(value = "/greetings{id}", method = RequestMethod.POST)
    public ResponseEntity<Greeting> getOne(@PathVariable("id") String idd) {
        return new ResponseEntity<>(greetingService.findOne(idd), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/greetings/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Greeting>> getByUserName(@PathVariable("name") String name) {
        return new ResponseEntity<>(greetingService.getGreetingByUsername(name), HttpStatus.OK);
    }

}

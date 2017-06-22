package com.impostercorp.customevent.controllers;

import com.impostercorp.customevent.publishers.CustomEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by sayeedm on 6/22/17.
 */
@RestController
@RequestMapping("/api/sample")
public class SampleController {

    @Autowired
    private CustomEventPublisher eventPublisher;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> sampleGetToRaiseEvent(){
        eventPublisher.publish();
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }
}

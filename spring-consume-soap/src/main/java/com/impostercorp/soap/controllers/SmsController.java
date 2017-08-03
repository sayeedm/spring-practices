package com.impostercorp.soap.controllers;

import com.impostercorp.soap.client.SoapClient;
import com.impostercorp.soap.requests.SendToOneSmsRequest;
import com.impostercorp.soap.wsdl.OneToOneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by sayeedm on 8/3/17.
 */
@RestController
@RequestMapping(value = "/api/sms")
public class SmsController {

    @Autowired
    private SoapClient soapClient;

    @RequestMapping(method = RequestMethod.PUT, value = "/{phoneNo}")
    public ResponseEntity<String> sendSmsToOne(@PathVariable("phoneNo") String phoneNo, @RequestBody SendToOneSmsRequest smsRequest){
        OneToOneResponse response = soapClient.sendSmsToOne(phoneNo, smsRequest.getSmsBody());
        return new ResponseEntity<>(response.getOneToOneResult(), HttpStatus.ACCEPTED);
    }

}

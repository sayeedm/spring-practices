package com.impostercorp.signuptest.controllers;

import com.impostercorp.signuptest.dtos.NewUserDto;
import com.impostercorp.signuptest.exceptions.EmailExistsException;
import com.impostercorp.signuptest.responses.BaseResponse;
import com.impostercorp.signuptest.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.validation.Valid;

/**
 *
 * Created by sayeedm on 7/4/17.
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService service;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<BaseResponse> register(@RequestBody @Valid NewUserDto dto, BindingResult result){
        if (!result.hasErrors()){
            if (service.create(dto) != null)
                return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            /* for now we are not thinking about error response formatting */
            BaseResponse response = new BaseResponse(result.getFieldErrors(), result.getGlobalErrors());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @ExceptionHandler({ EmailExistsException.class })
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity onDuplicateEmail(Exception ex, WebRequest req) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

package com.impostercorp.signuptest.controllers;

import com.impostercorp.signuptest.dtos.NewUserDto;
import com.impostercorp.signuptest.responses.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 *
 * Created by sayeedm on 7/4/17.
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<BaseResponse> register(@RequestBody @Valid NewUserDto dto, BindingResult result){
        if (!result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            BaseResponse response = new BaseResponse(result.getFieldErrors(), result.getGlobalErrors());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}

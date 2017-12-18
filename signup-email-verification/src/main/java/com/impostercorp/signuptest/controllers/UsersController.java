package com.impostercorp.signuptest.controllers;

import com.impostercorp.signuptest.dtos.NewUserDto;
import com.impostercorp.signuptest.exceptions.EmailExistsException;
import com.impostercorp.signuptest.exceptions.NoVerificationTokenFoundException;
import com.impostercorp.signuptest.exceptions.VerificationTokenExpiredException;
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
    public ResponseEntity<BaseResponse> register(@RequestBody @Valid NewUserDto dto, BindingResult result, WebRequest request){
        if (!result.hasErrors()){
            dto.setContextPath(request.getContextPath());

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

    @RequestMapping(method = RequestMethod.GET, value = "/verify", params = { "token" })
    public ResponseEntity<BaseResponse> register(@RequestParam("token") String token){
        service.verifyEmail(token);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @ExceptionHandler({ EmailExistsException.class })
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity onDuplicateEmail(Exception ex, WebRequest req) {
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ NoVerificationTokenFoundException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity onVerificationTokenNotFound(Exception ex, WebRequest req) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ VerificationTokenExpiredException.class })
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity onVerificationTokenExpired(Exception ex, WebRequest req) {
        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
    }
}

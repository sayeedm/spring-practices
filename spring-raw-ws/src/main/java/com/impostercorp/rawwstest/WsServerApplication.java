package com.impostercorp.rawwstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by sayeedm on 3/6/17.
 */
@SpringBootApplication
public class WsServerApplication extends SpringBootServletInitializer{

    public static void main(String [] args){
        SpringApplication.run(WsServerApplication.class, args);
    }
}

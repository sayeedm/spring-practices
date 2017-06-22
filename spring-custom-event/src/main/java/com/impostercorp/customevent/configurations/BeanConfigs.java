package com.impostercorp.customevent.configurations;

import com.impostercorp.customevent.eventhandlers.CustomEventHandler;
import com.impostercorp.customevent.publishers.CustomEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Created by sayeedm on 6/22/17.
 */
@Configuration
public class BeanConfigs {

    @Bean
    public CustomEventPublisher customEventPublisher(){
        System.out.println("creating bean custom event publisher");
        return new CustomEventPublisher();
    }

    @Bean
    public CustomEventHandler customEventHandler(){
        System.out.println("creating bean custom event handler");
        return new CustomEventHandler();
    }
}

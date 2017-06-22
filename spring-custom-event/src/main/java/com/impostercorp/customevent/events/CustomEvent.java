package com.impostercorp.customevent.events;

import org.springframework.context.ApplicationEvent;

/**
 *
 * Created by sayeedm on 6/22/17.
 */
public class CustomEvent extends ApplicationEvent {

    public CustomEvent(Object source) {
        super(source);
    }

    @Override
    public String toString(){
        return "Custom Event";
    }

}

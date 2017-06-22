package com.impostercorp.customevent.eventhandlers;

import com.impostercorp.customevent.events.CustomEvent;
import org.springframework.context.ApplicationListener;

/**
 *
 * Created by sayeedm on 6/22/17.
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println("Custom event arrived " + customEvent.toString());
    }
}

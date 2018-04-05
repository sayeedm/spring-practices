package com.impostercorp.schedule.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by sayeedm on 4/5/18.
 */
@SuppressWarnings("SpellCheckingInspection")
@Component
public class ScheduledComponent {

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Scheduled(fixedDelay = 5000)
    public void scheduledMethod(){

        System.out.println(format.format(new Date(System.currentTimeMillis())) + ": Method executed");
        System.out.println("Next excution will take place only after I finish sleeping");
        System.out.println("Interval or Rate doesn't matter in this case");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

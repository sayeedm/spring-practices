package com.impostercorp.schedule.method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Scanner;

/**
 *
 * Created by sayeedm on 4/5/18.
 */
@SuppressWarnings("SpellCheckingInspection")
@SpringBootApplication
@EnableScheduling
public class MethodScheduleApp {

    public static void main(String [] args){
        SpringApplication.run(MethodScheduleApp.class, args);

        Scanner inputReader = new Scanner(System.in);
        String input = "";
        while (!input.equals("q")){
            input = inputReader.nextLine();
        }

    }

}

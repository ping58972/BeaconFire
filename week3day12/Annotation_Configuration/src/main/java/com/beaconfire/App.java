package com.beaconfire;

import com.beaconfire.model.Coach;
import com.beaconfire.model.FootBall;
import com.beaconfire.model.Golf;
import com.beaconfire.model.Tennis;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Tennis tennis = ctx.getBean(Tennis.class);
        tennis.getDailyWorkOutSchedule();
        Golf golf = ctx.getBean(Golf.class);
        golf.getDailyWorkOutSchedule();
        FootBall footBall = ctx.getBean(FootBall.class);
        footBall.getDailyWorkOutSchedule();
    }
}

package com.beaconfire;

import com.beaconfire.model.Coach;
import com.beaconfire.model.FootBall;
import com.beaconfire.model.Golf;
import com.beaconfire.model.Tennis;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         ApplicationContext ctx =  new ClassPathXmlApplicationContext("beans.xml");
        Coach tennis = ctx.getBean(Tennis.class);
        tennis.getDailyWorkOutSchedule();
        Coach golf = ctx.getBean(Golf.class);
        golf.getDailyWorkOutSchedule();
        Coach footBall = ctx.getBean(FootBall.class);
        footBall.getDailyWorkOutSchedule();
    }
}

package com.beaconfire.springaop.AOPDemo.service;


import com.beaconfire.springaop.AOPDemo.dao.DemoDAO;
import com.beaconfire.springaop.AOPDemo.domain.Demo;
import com.beaconfire.springaop.AOPDemo.exception.DemoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private DemoDAO demoDAO;

    @Autowired
    public void setDemoDAO(DemoDAO demoDAO) {
        this.demoDAO = demoDAO;
    }

    public Demo getADemo(){
        return demoDAO.getADemo();
    }

    public Demo getAErrorDemo() throws DemoNotFoundException {
        return demoDAO.getAErrorDemo();
    }
}

package com.spring.jdbc.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCConfigTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

          BikeDAO bikeDAO = context.getBean("bikeDao",BikeDAO.class);
          int bikeCount = bikeDAO.getNoOfBikes();
        System.out.println("bikeCount: "+bikeCount);

        String bikeName = bikeDAO.getNoOfBikeName(1);
        System.out.println(bikeName);

        BikeBo bikeBo = bikeDAO.getBikeInfo(3);
        System.out.println(bikeBo);

    }
}

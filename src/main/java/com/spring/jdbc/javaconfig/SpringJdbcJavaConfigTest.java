package com.spring.jdbc.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJdbcJavaConfigTest {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        BikeDao bikeDao = context.getBean("bikeDao",BikeDao.class);
       int bikeCount =  bikeDao.getNoOfBikes();
        System.out.println("Bike Count----"+bikeCount);
    }
}

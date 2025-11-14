package com.spring.jdbc.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.stream.Stream;

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

        BikeBo bikeBoObject = new BikeBo();
        bikeBoObject.setBikeNo(4);
        bikeBoObject.setBikeName("Pluser");
        bikeBoObject.setBikeColor("Green");
        bikeBoObject.setBikeModel("B4");

        int status = bikeDAO.addBike(bikeBoObject);

        System.out.println("row updated: "+" "+status);

        List<BikeBo> bikeBos = bikeDAO.getAllBikes();
        Stream sBikes = Stream.of(bikeBos);
        //bikeBos.stream().forEach(System.out::println);
        sBikes.forEach(System.out::println);

    }
}

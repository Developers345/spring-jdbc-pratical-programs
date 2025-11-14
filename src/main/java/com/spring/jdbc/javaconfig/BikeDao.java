package com.spring.jdbc.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BikeDao {

    private final String GET_BIKE_COUNT="select count(1) from bike";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getNoOfBikes()
    {
        return jdbcTemplate.queryForObject(GET_BIKE_COUNT,Integer.class);
    }
}

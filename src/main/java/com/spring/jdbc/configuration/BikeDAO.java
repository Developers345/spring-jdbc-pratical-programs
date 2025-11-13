package com.spring.jdbc.configuration;
import org.springframework.jdbc.core.JdbcTemplate;
public class BikeDAO {

    private final static String GET_BIKE_COUNT="select count(1) from bike";
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getNoOfBikes()
     {
         return jdbcTemplate.queryForObject(GET_BIKE_COUNT,Integer.class);
     }
}

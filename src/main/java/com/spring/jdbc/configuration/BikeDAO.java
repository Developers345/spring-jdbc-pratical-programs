package com.spring.jdbc.configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BikeDAO {

    private final String GET_BIKE_COUNT = "select count(1) from bike";
    private final String GET_BIKE_NAME = "select bike_name from bike where bike_no= ?";
    private final String GET_BIKE_BY_BIKE_NO = "select bike_no,bike_name,bike_color,bike_model from bike where bike_no= ?";
    private final String GET_ALL_BIKES = "select bike_no,bike_name,bike_color,bike_model from bike";
    private final String INSERT_BIKE_DATA = "insert into bike values(?,?,?,?)";


    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getNoOfBikes()
     {
         return jdbcTemplate.queryForObject(GET_BIKE_COUNT,Integer.class);
     }
    public String getNoOfBikeName(int bikeNo)
    {
        return jdbcTemplate.queryForObject(GET_BIKE_NAME,String.class, bikeNo);
    }

    public BikeBo getBikeInfo(int bikeNo)
    {
        return jdbcTemplate.queryForObject(GET_BIKE_BY_BIKE_NO,rowMapper,bikeNo);
    }

    public List<BikeBo> getAllBikes()
    {
          return jdbcTemplate.query(GET_ALL_BIKES,rowMapper);
    }

    public int addBike(BikeBo bikeBo)
    {
        return jdbcTemplate.update(INSERT_BIKE_DATA, bikeBo.getBikeNo(),bikeBo.getBikeName(), bikeBo.getBikeColor(), bikeBo.getBikeModel());
    }

    /* Lambda expressions are suitable for use the method only once
    if multiple places we can use then Lambda expression not recommanded.

    (rs,rowNum)->{
        BikeBo bikeBo = null;
        bikeBo = new BikeBo();
        bikeBo.setBikeNo(rs.getInt(1));
        bikeBo.setBikeName(rs.getString(2));
        bikeBo.setBikeColor(rs.getString(3));
        bikeBo.setBikeModel(rs.getString(4));
        return bikeBo;
    }
    */
    //We can go for anonymous inner class or private inner class
    RowMapper<BikeBo> rowMapper = new RowMapper<BikeBo>() {
        @Override
        public BikeBo mapRow(ResultSet rs, int rowNum) throws SQLException {
            BikeBo bikeBo = null;
            bikeBo = new BikeBo();
            bikeBo.setBikeNo(rs.getInt(1));
            bikeBo.setBikeName(rs.getString(2));
            bikeBo.setBikeColor(rs.getString(3));
            bikeBo.setBikeModel(rs.getString(4));
            return bikeBo;
        }
    };


}

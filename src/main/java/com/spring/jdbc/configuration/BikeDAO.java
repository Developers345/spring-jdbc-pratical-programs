package com.spring.jdbc.configuration;
import org.springframework.jdbc.core.JdbcTemplate;
public class BikeDAO {

    private final String GET_BIKE_COUNT = "select count(1) from bike";
    private final String GET_BIKE_NAME = "select bike_name from bike where bike_no= ?";
    private final String GET_BIKE_BY_BIKE_NO = "select bike_no,bike_name,bike_color,bike_model from bike where bike_no= ?";


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
        return jdbcTemplate.queryForObject(GET_BIKE_BY_BIKE_NO,(rs,rowNum)->{
            BikeBo bikeBo = null;
            bikeBo = new BikeBo();
            bikeBo.setBikeNo(rs.getInt(1));
            bikeBo.setBikeName(rs.getString(2));
            bikeBo.setBikeColor(rs.getString(3));
            bikeBo.setBikeModel(rs.getString(4));
            return bikeBo;
        },bikeNo);
    }


}

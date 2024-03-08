package com.springgmap.dao.impl;

import com.springgmap.dao.RestaurantDao;
import com.springgmap.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

// I Love JPA :)
@Repository
@RequiredArgsConstructor
public class RestaurantDaoImpl implements RestaurantDao {

    private static final Logger LOGGER= LoggerFactory.getLogger(RestaurantDaoImpl.class);
    private final JdbcTemplate jdbcTemplate;

    RowMapper<Restaurant> rowMapper=(rs,rowNum)->{
        Restaurant restaurant=new Restaurant();
        restaurant.setId(rs.getLong("id"));
        restaurant.setLat(rs.getDouble("lat"));
        restaurant.setLng(rs.getDouble("lng"));
        restaurant.setRestaurantId(rs.getString("restaurant_id"));
        restaurant.setName(rs.getString("name"));
        restaurant.setTypes(rs.getString("types"));
        restaurant.setVicinity(rs.getString("vicinity"));
        restaurant.setDeleted(rs.getBoolean("is_deleted"));
        return restaurant;
    };

    @Override
    public List<Restaurant> list() {
        String sql="SELECT id,lat,lng,restaurant_id,name,types,vicinity,is_deleted  FROM restaurant";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Restaurant restaurant) {
        String sql = "INSERT INTO restaurant(lat, lng, restaurant_id, name, types, vicinity, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?)";

        int insert = jdbcTemplate.update(
                sql,
                restaurant.getLat(),
                restaurant.getLng(),
                restaurant.getRestaurantId(),
                restaurant.getName(),
                restaurant.getTypes(),
                restaurant.getVicinity(),
                false);

        if(insert == 1) {
            LOGGER.info("Restaurant added: {} ", restaurant.getName());
        }
    }

    @Override
    public Restaurant get(Long id) {
        String sql="SELECT id,lat, lng, restaurant_id, name, types, vicinity, is_deleted FROM restaurant WHERE id= ?";

        Restaurant restaurant=null;

        try {
            restaurant=jdbcTemplate.queryForObject(sql,new Object[]{id},rowMapper);
        }catch(DataAccessException e){
            LOGGER.info("NOT FOUND ");
        }

        return restaurant;
    }

    @Override
    public void update(Restaurant restaurant, Long id) {
        String sql = "UPDATE restaurant SET lat = ?, lng = ?, restaurant_id = ?, name = ?, vicinity = ?, types = ?, is_deleted = ? WHERE id = ?";

        int update = jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, restaurant.getLat());
            ps.setDouble(2, restaurant.getLng());
            ps.setString(3, restaurant.getRestaurantId());
            ps.setString(4, restaurant.getName());
            ps.setString(5, restaurant.getVicinity());
            ps.setString(6, restaurant.getTypes());
            ps.setBoolean(7, restaurant.isDeleted());
            ps.setLong(8, id);
            return ps;
        });

        if (update == 1) {
            LOGGER.info("Restaurant updated: {}", restaurant.getName());
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM restaurant WHERE id=?",id);
    }
}

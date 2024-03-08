package com.springgmap.dao;

import com.springgmap.model.Restaurant;

import java.util.List;

public interface RestaurantDao {
    List<Restaurant> list();
    void create(Restaurant restaurant);
    Restaurant get(Long id);
    void delete(Long id);
    void update(Restaurant restaurant, Long id);
}

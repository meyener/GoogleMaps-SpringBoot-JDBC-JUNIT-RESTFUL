package com.springgmap.service;

import com.springgmap.model.LocationRequest;
import com.springgmap.model.Restaurant;

import java.util.List;

public interface GooglePlaceService {
    Restaurant getRestaurantById(Long id);

    List<Restaurant> getAll();

    String searchNearbyPlaces(LocationRequest request);

    void saveRestaurantWithLocationAndRadius(LocationRequest request);

    void softDelete(Long id);
}

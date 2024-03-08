package com.springgmap.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springgmap.dao.RestaurantDao;
import com.springgmap.exception.RestaurantException;
import com.springgmap.model.LocationRequest;
import com.springgmap.model.Restaurant;
import com.springgmap.service.GooglePlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class GooglePlaceServiceImpl implements GooglePlaceService {

    //put yours
    @Value("${google.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final RestaurantDao productDao;

    @Override
    public Restaurant getRestaurantById(Long id) {
        return productDao.get(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return productDao.list().stream().filter(rst-> !rst.isDeleted()).toList();
    }

    @Override
    public String searchNearbyPlaces(LocationRequest request) {
        String urlForRequest = createUrlString(request);

        return restTemplate.getForObject(urlForRequest, String.class);
    }

    @Override
    public void saveRestaurantWithLocationAndRadius(LocationRequest request) {

        String json = searchNearbyPlaces(request);

        JsonNode resultsNode = getJsonReturnJsonNode(json);
        for (JsonNode jsonNode : resultsNode) {

            Restaurant restaurant = returnRestaurantByJsonNode(jsonNode);

            if (restaurant.getTypes().contains("restaurant")) {
                log.info(restaurant.toString());

                productDao.create(restaurant);
            }
        }
    }

    @Override
    public void softDelete(Long id) {
        Restaurant restaurant = productDao.get(id);
        restaurant.setDeleted(true);
        productDao.update(restaurant,id);

    }

    private JsonNode getJsonReturnJsonNode(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode;

        try {
            rootNode = objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RestaurantException(e.getMessage());
        }

        return rootNode.get("results");
    }

    private String createUrlString(LocationRequest request) {
        return "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
                + request.getLatitude() + "," + request.getLongitude() + "&radius=" + request.getRadius() + "&key=" + apiKey;
    }

    private Restaurant returnRestaurantByJsonNode(JsonNode jsonNode) {
        String types = jsonNode.get("types").toString();

        JsonNode geometryNode = jsonNode.get("geometry");
        JsonNode locationNode = geometryNode.get("location");

        double lat = locationNode.get("lat").asDouble();
        double lng = locationNode.get("lng").asDouble();

        String restaurantId = jsonNode.get("place_id").asText();
        String name = jsonNode.get("name").asText();
        String vicinity = null;

        try {
            vicinity = jsonNode.get("vicinity").asText();
        } catch (Exception e) {
            log.info("vicinity is empty !!");
        }

        return new Restaurant(lat, lng, restaurantId, name, types, vicinity, false);
    }

}

package com.springgmap.controller;

import com.springgmap.model.LocationRequest;
import com.springgmap.model.Restaurant;
import com.springgmap.service.GooglePlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NearbyController {

    private final GooglePlaceService googlePlaceService;

    @GetMapping("/getbyid/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return googlePlaceService.getRestaurantById(id);
    }
    @GetMapping("/restaurants")
    public List<Restaurant> getAll() {
        return googlePlaceService.getAll();
    }
    @GetMapping("/search-places")
    public String searchPlaces(@RequestBody LocationRequest request) {
        return googlePlaceService.searchNearbyPlaces(request);
    }
    @PostMapping("/save-places")
    public void savePlaces(@RequestBody LocationRequest request) {
        googlePlaceService.saveRestaurantWithLocationAndRadius(request);
    }
    @PutMapping("/softDelete/{id}")
    public void softDelete(@PathVariable Long id) {
        googlePlaceService.softDelete(id);
    }

}
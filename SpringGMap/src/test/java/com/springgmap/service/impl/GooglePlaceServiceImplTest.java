package com.springgmap.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springgmap.dao.RestaurantDao;
import com.springgmap.model.LocationRequest;
import com.springgmap.model.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.*;

class GooglePlaceServiceImplTest {
    @Mock
    RestTemplate restTemplate;
    @Mock
    RestaurantDao productDao;
    @InjectMocks
    GooglePlaceServiceImpl googlePlaceServiceImpl;

    @Mock
    ObjectMapper objectMapper;
    List<Restaurant> restaurantList;
    Restaurant restaurant;

    LocationRequest request;
    @BeforeEach
    void setUp() {MockitoAnnotations.openMocks(this);
        restaurant=Restaurant.builder().id(1L).restaurantId("1").lng(1d).types("a").build();
        request=new LocationRequest(1d,1d,1L);

        restaurantList= List.of(restaurant);

    }

    @Test
    void testGetRestaurantById() {
        when(productDao.get(anyLong())).thenReturn(restaurant);

        Restaurant result = googlePlaceServiceImpl.getRestaurantById(1L);
        Assertions.assertEquals(restaurant.getId(), result.getId());
    }

    @Test
    void testGetAll() {
        when(productDao.list()).thenReturn(restaurantList);

        List<Restaurant> result = googlePlaceServiceImpl.getAll();
        Assertions.assertEquals(restaurantList.size(), result.size());
    }

    @Test
    void testSearchNearbyPlaces() {
        String str="exp";
        when(googlePlaceServiceImpl.searchNearbyPlaces(request)).thenReturn(str);
        when(restTemplate.getForObject(str, String.class)).thenReturn(str);
        Assertions.assertNotNull(str);
    }

    @Test
    void testSaveRestaurantWithLocationAndRadius() throws JsonProcessingException {
        String mockJson = "{\"results\":[{\"types\":[\"restaurant\"],\"geometry\":{\"location\":{\"lat\":37.0625, \"lng\":37.387222}},\"place_id\":\"some-restaurant-id\",\"name\":\"Sample Restaurant\",\"vicinity\":\"Sample Vicinity\"}]}";
        when(restTemplate.getForObject(any(String.class), eq(String.class))).thenReturn(mockJson);
        when(objectMapper.readTree(mockJson)).thenReturn(mock(JsonNode.class));
        doNothing().when(productDao).create(any(Restaurant.class));

        googlePlaceServiceImpl.saveRestaurantWithLocationAndRadius(request);

        verify(restTemplate).getForObject(any(String.class), eq(String.class));

    }

    @Test
    void testSoftDelete() {
        when(productDao.get(anyLong())).thenReturn(restaurant);
        googlePlaceServiceImpl.softDelete(1L);
    }
}


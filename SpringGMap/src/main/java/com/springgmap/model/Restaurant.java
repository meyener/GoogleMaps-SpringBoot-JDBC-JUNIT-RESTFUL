package com.springgmap.model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    private Long id;
    private double lat;
    private double lng;
    private String restaurantId;
    private String name;
    private String types;
    private String vicinity;
    private boolean isDeleted;

    public Restaurant(double lat, double lng,String restaurantId , String name, String types, String vicinity,boolean isDeleted) {
        this.lat = lat;
        this.lng = lng;
        this.restaurantId = restaurantId;
        this.name = name;
        this.types = types;
        this.vicinity = vicinity;
        this.isDeleted=isDeleted;
    }

    @Override
    public String toString(){

        return "Location : latitude= "+lat+
                ", longitude= "+lng+
                ", restaurant_id= "+restaurantId+
                ", name= "+name+
                ", types= "+types+
                ", vicinity"+vicinity;
    }
}

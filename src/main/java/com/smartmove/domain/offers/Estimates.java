package com.smartmove.domain.offers;


/**
 * 
 * @author TCS
 *
 */
public class Estimates {

    private VechicleView vehicle_view;
    private String fare_string;
    
    public VechicleView getVehicle_view() {
        return vehicle_view;
    }

    
    public void setVehicle_view(VechicleView vehicle_view) {
        this.vehicle_view = vehicle_view;
    }


    
    public String getFare_string() {
        return fare_string;
    }


    
    public void setFare_string(String fare_string) {
        this.fare_string = fare_string;
    } 
}

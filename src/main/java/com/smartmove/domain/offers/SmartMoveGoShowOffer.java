/**
 * 
 */
package com.smartmove.domain.offers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.smartmove.domain.common.SmError;



/**
 * @author x074395
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class SmartMoveGoShowOffer {

    //private String flight = "KL 1227 AMS CDG 01-JAN-2015";

    private Flight bookedFlight;
    private List<Flight> alertnateFlights;
    
    public List<Flight> getAlertnateFlights() {
        return alertnateFlights;
    }

    
    public void setAlertnateFlights(List<Flight> alertnateFlights) {
        this.alertnateFlights = alertnateFlights;
    }

    private SmError error;
    
    public Flight getBookedFlight() {
        return bookedFlight;
    }
    
    public void setBookedFlight(Flight bookedFlight) {
        this.bookedFlight = bookedFlight;
    }
    
    
    public SmError getError() {
        return error;
    }
    
    public void setError(SmError error) {
        this.error = error;
    }


//    public String getFlight() {
//        return flight;
//    }
//
//    
//    public void setFlight(String flight) {
//        this.flight = flight;
//    }
//    
}

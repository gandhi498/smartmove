package com.smartmove.domain.reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * List of reservations.
 */
public class ListOfReservations {
	
    private List<Reservation> reservations;

    /**
     * @return the reservations
     */
    public List<Reservation> getReservations() {
    	if (null == reservations) {
    		reservations = new ArrayList<Reservation>();
    	}
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
}

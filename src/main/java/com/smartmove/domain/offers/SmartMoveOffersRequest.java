/**
 * 
 */
package com.smartmove.domain.offers;

import java.util.ArrayList;
import java.util.List;

import com.smartmove.domain.common.SmartMoveLink;

/**
 * @author TCS
 *
 */
public class SmartMoveOffersRequest {
    private String userGPSLocationLat;
    private String airportGPSLocationLat;
    private String userGPSLocationLong;
    private String airportGPSLocationLong;    
    private String distance;
    private String mode;
    private String pnr;
    private String flightNumber;
    private int eta;
    private List<SmartMoveLink> links;
    private List<RelevantOffer> offers;
    private String zone;
       
    /**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}

	/**
	 * @return the offers
	 */
	public List<RelevantOffer> getOffers() {
		if (null == offers) {
			offers = new ArrayList<RelevantOffer>();
		}
		return offers;
	}
	
	/**
	 * Add the offers
	 */
	public void addRelevantOffer(RelevantOffer o) {
		getOffers().add(o);
	}	

	/**
	 * @param offers the offers to set
	 */
	public void setOffers(List<RelevantOffer> offers) {
		this.offers = offers;
	}

	/**
	 * @return the links
	 */
	public List<SmartMoveLink> getLinks() {
		return links;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(List<SmartMoveLink> links) {
		this.links = links;
	}
    
	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the pnr
	 */
	public String getPnr() {
		return pnr;
	}
	/**
	 * @param pnr the pnr to set
	 */
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	/**
	 * @return the eta
	 */
	public int getEta() {
		return eta;
	}
	/**
	 * @param eta the eta to set
	 */
	public void setEta(int eta) {
		this.eta = eta;
	}

	/**
	 * @return the userGPSLocationLat
	 */
	public String getUserGPSLocationLat() {
		return userGPSLocationLat;
	}

	/**
	 * @param userGPSLocationLat the userGPSLocationLat to set
	 */
	public void setUserGPSLocationLat(String userGPSLocationLat) {
		this.userGPSLocationLat = userGPSLocationLat;
	}

	/**
	 * @return the airportGPSLocationLat
	 */
	public String getAirportGPSLocationLat() {
		return airportGPSLocationLat;
	}

	/**
	 * @param airportGPSLocationLat the airportGPSLocationLat to set
	 */
	public void setAirportGPSLocationLat(String airportGPSLocationLat) {
		this.airportGPSLocationLat = airportGPSLocationLat;
	}

	/**
	 * @return the userGPSLocationLong
	 */
	public String getUserGPSLocationLong() {
		return userGPSLocationLong;
	}

	/**
	 * @param userGPSLocationLong the userGPSLocationLong to set
	 */
	public void setUserGPSLocationLong(String userGPSLocationLong) {
		this.userGPSLocationLong = userGPSLocationLong;
	}

	/**
	 * @return the airportGPSLocationLong
	 */
	public String getAirportGPSLocationLong() {
		return airportGPSLocationLong;
	}

	/**
	 * @param airportGPSLocationLong the airportGPSLocationLong to set
	 */
	public void setAirportGPSLocationLong(String airportGPSLocationLong) {
		this.airportGPSLocationLong = airportGPSLocationLong;
	}
}

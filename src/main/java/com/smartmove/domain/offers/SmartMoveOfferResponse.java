/**
 * 
 */
package com.smartmove.domain.offers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author x074395
 * 
 */
@JsonInclude(Include.NON_EMPTY)
public class SmartMoveOfferResponse {

    private String userGPSLocationLat;
    private String airportGPSLocationLat;
    private String userGPSLocationLong;
    private String airportGPSLocationLong;
    private String distance;
    private String mode;
    private String pnr;
    private String flightNumber;
    private int eta;
    private List<RelevantOffer> offers;
    private String zone;

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void addOffer(RelevantOffer offer) {
        if (offers == null) {
            offers = new ArrayList<RelevantOffer>();
        }
        if (null != offer) {
            offers.add(offer);
        }
    }

    public List<RelevantOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<RelevantOffer> offers) {
        this.offers = offers;
    }

    public String getUserGPSLocationLat() {
        return userGPSLocationLat;
    }

    public void setUserGPSLocationLat(String userGPSLocationLat) {
        this.userGPSLocationLat = userGPSLocationLat;
    }

    public String getAirportGPSLocationLat() {
        return airportGPSLocationLat;
    }

    public void setAirportGPSLocationLat(String airportGPSLocationLat) {
        this.airportGPSLocationLat = airportGPSLocationLat;
    }

    public String getUserGPSLocationLong() {
        return userGPSLocationLong;
    }

    public void setUserGPSLocationLong(String userGPSLocationLong) {
        this.userGPSLocationLong = userGPSLocationLong;
    }

    public String getAirportGPSLocationLong() {
        return airportGPSLocationLong;
    }

    public void setAirportGPSLocationLong(String airportGPSLocationLong) {
        this.airportGPSLocationLong = airportGPSLocationLong;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

}

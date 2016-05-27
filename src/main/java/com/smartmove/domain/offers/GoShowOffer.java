package com.smartmove.domain.offers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author TCS
 * 
 */
@JsonInclude(Include.NON_EMPTY)
public class GoShowOffer extends RelevantOffer {

    @JsonIgnore
    private String pnr;
    @JsonIgnore
    private String flightNumber;

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
}

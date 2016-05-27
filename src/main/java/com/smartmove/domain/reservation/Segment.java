package com.smartmove.domain.reservation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Segment class
 */
@JsonInclude(Include.NON_NULL)
public class Segment {
    
    private String departFrom;
    private String arriveOn;
    private String marketingFlight;
    
    
	/**
	 * @return the departFrom
	 */
	public String getDepartFrom() {
		return departFrom;
	}
	/**
	 * @param departFrom the departFrom to set
	 */
	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}
	/**
	 * @return the arriveOn
	 */
	public String getArriveOn() {
		return arriveOn;
	}
	/**
	 * @param arriveOn the arriveOn to set
	 */
	public void setArriveOn(String arriveOn) {
		this.arriveOn = arriveOn;
	}
	/**
	 * @return the marketingFlight
	 */
	public String getMarketingFlight() {
		return marketingFlight;
	}
	/**
	 * @param marketingFlight the marketingFlight to set
	 */
	public void setMarketingFlight(String marketingFlight) {
		this.marketingFlight = marketingFlight;
	}
    
    
}

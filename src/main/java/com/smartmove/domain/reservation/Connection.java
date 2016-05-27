package com.smartmove.domain.reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smartmove.util.JsonDateSerializer;

/**
 * Connection class
 */
@JsonInclude(Include.NON_NULL)
public class Connection {

    private List<Segment> segments = new ArrayList<>();

    private String departFrom;
    private String arriveOn;
    private String marketingFlight;
	private Date localScheduledArrival;
    private Date localScheduledDeparture;
    
    


    
	/**
	 * @return the segments
	 */
	public List<Segment> getSegments() {
		return segments;
	}
	/**
	 * @param segments the segments to set
	 */
	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
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
	/**
	 * @return the localScheduledArrival
	 */
    @JsonSerialize(using=JsonDateSerializer.class)
	public Date getLocalScheduledArrival() {
		return localScheduledArrival;
	}
	/**
	 * @param localScheduledArrival the localScheduledArrival to set
	 */
	public void setLocalScheduledArrival(Date localScheduledArrival) {
		this.localScheduledArrival = localScheduledArrival;
	}
	/**
	 * @return the localScheduledDeparture
	 */
    @JsonSerialize(using=JsonDateSerializer.class)
	public Date getLocalScheduledDeparture() {
		return localScheduledDeparture;
	}
	/**
	 * @param localScheduledDeparture the localScheduledDeparture to set
	 */
	public void setLocalScheduledDeparture(Date localScheduledDeparture) {
		this.localScheduledDeparture = localScheduledDeparture;
	}

}

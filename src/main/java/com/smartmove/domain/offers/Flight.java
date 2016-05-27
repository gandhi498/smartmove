/**
 * 
 */
package com.smartmove.domain.offers;

import java.util.Calendar;

import org.joda.time.Duration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.smartmove.util.JsonDateSerializer;


/**
 * @author x074395
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class Flight {
    
    private String marketingFlightNumber;
    private String marketedBy;
    private String operatedBy;
    private String operatingFlightNumber;
    private Calendar departureDate;
    private String departure;
    private String arrival;
    private Duration journeyTime;
    
    public String getMarketingFlightNumber() {
        return marketingFlightNumber;
    }
    
    public void setMarketingFlightNumber(String marketingFlightNumber) {
        this.marketingFlightNumber = marketingFlightNumber;
    }
    
    public String getMarketedBy() {
        return marketedBy;
    }
    
    public void setMarketedBy(String marketedBy) {
        this.marketedBy = marketedBy;
    }
    
    public String getOperatedBy() {
        return operatedBy;
    }
    
    public void setOperatedBy(String operatedBy) {
        this.operatedBy = operatedBy;
    }
    
    public String getOperatingFlightNumber() {
        return operatingFlightNumber;
    }
    
    public void setOperatingFlightNumber(String operatingFlightNumber) {
        this.operatingFlightNumber = operatingFlightNumber;
    }
    
    @JsonSerialize(using=JsonDateSerializer.class)
    public Calendar getDepartureDate() {
        return departureDate;
    }
    
    public void setDepartureDate(Calendar departureDate) {
        this.departureDate = departureDate;
    }
    
    public String getDeparture() {
        return departure;
    }
    
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    
    public String getArrival() {
        return arrival;
    }
    
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    
    public Duration getJourneyTime() {
        return journeyTime;
    }
    
    public void setJourneyTime(Duration journeyTime) {
        this.journeyTime = journeyTime;
    }
    
}

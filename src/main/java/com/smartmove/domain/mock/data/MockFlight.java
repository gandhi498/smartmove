/**
 * 
 */
package com.smartmove.domain.mock.data;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

import com.smartmove.util.DateTimeConversionUtil;


/**
 * @author TCS
 *
 */
public class MockFlight {
    
    @Id
    private String flight_id;
    private String marketingFlight;
    private String operatingFlight;
    private String origin;
    private String destination;
    private String flight_hours;
    private String origin_time_zone;
    private String departure_time;
    private String boarding_offset;
    private String checkin_close_time;
    private String arrival_time_zone;
    private String status;
    
    public String getFlight_id() {
        return flight_id;
    }
    
    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }
    
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getFlight_hours() {
        return flight_hours;
    }
    
    public void setFlight_hours(String flight_hours) {
        this.flight_hours = flight_hours;
    }
    
    public String getOrigin_time_zone() {
        return origin_time_zone;
    }
    
    public void setOrigin_time_zone(String origin_time_zone) {
        this.origin_time_zone = origin_time_zone;
    }
    
    public String getDeparture_time() {
        return departure_time;
    }
    
    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }
    
    public String getBoarding_offset() {
        return boarding_offset;
    }
    
    public void setBoarding_offset(String boarding_offset) {
        this.boarding_offset = boarding_offset;
    }
    
    public String getCheckin_close_time() {
        return checkin_close_time;
    }
    
    public void setCheckin_close_time(String checkin_close_time) {
        this.checkin_close_time = checkin_close_time;
    }
    
    public String getArrival_time_zone() {
        return arrival_time_zone;
    }
    
    public void setArrival_time_zone(String arrival_time_zone) {
        this.arrival_time_zone = arrival_time_zone;
    }
    
    public String getStatus() {
        return status;
    }
    
    
    public String getMarketingFlight() {
        return marketingFlight;
    }

    
    public void setMarketingFlight(String marketingFlight) {
        this.marketingFlight = marketingFlight;
    }

    
    public String getOperatingFlight() {
        return operatingFlight;
    }

    
    public void setOperatingFlight(String operatingFlight) {
        this.operatingFlight = operatingFlight;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DateTime getDepartureDateTime() {
        return DateTimeConversionUtil.getDateTimeValue(departure_time, origin_time_zone);
    }

    public DateTime getArrivalDateTime() {
        return DateTimeConversionUtil.getDateTimeValue(DateTimeConversionUtil.getDateTimeValue(departure_time, origin_time_zone), flight_hours, arrival_time_zone);
    }
    
}

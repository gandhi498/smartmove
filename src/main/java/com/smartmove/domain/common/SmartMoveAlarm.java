/**
 * 
 */
package com.smartmove.domain.common;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


/**
 * @author TCS
 *
 */
public class SmartMoveAlarm {

    private String pnr;
    private String flightNumber;
    private String snoozeTime;
    
    private URI goShowOffer;
    
    private List<SmartMoveLink> links;
    
    public List<SmartMoveLink> getLinks() {
        if (null != links) {
            links.clear();
        }
        else {
            links = new ArrayList<SmartMoveLink>();
        }
        if (null != goShowOffer)
            links.add(new SmartMoveLink(goShowOffer.toString(), "_offers", null));
        return links;
    }

    
    public void setLinks(List<SmartMoveLink> links) {
        this.links = links;
    }

    public SmartMoveAlarm() {
        super();
    }
    
    public SmartMoveAlarm(String pnr, String flightNumber, String snoozeTime) {
        super();
        this.pnr = pnr;
        this.flightNumber = flightNumber;
        this.snoozeTime = snoozeTime;
    }

    public String getSnoozeTime() {
        return snoozeTime;
    }

    
    public void setSnoozeTime(String snoozeTime) {
        this.snoozeTime = snoozeTime;
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
    
}

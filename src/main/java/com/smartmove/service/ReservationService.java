/**
 * 
 */
package com.smartmove.service;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.smartmove.domain.reservation.Reservation;

/**
 * @author TCS
 *
 */
@Service
public class ReservationService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ReservationService.class);
	
    public Reservation retrieveBooking(Reservation reservation) throws Exception {
        return null;
    }
    
    /**
     * Create JAVA date object combining date and time from a segment
     * @param date XMLGregorianCalendar
     * @param time XMLGregorianCalendar
     * @return Java Date
     */
    private Date getDateTime(XMLGregorianCalendar date, XMLGregorianCalendar time) {
    	
    	// to be improved
    	date.setHour(time.getHour());
    	date.setMinute(time.getMinute());
    	Date dateFinal = date.toGregorianCalendar().getTime();
    	return dateFinal;
    }
}
 
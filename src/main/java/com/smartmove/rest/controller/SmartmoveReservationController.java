/**
 * 
 */
package com.smartmove.rest.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartmove.domain.reservation.Reservation;
import com.smartmove.mongodb.repository.BookingRepository;
import com.smartmove.service.ReservationService;

/**
 * @author TCS
 * 
 */
@RestController
@RequestMapping("/users/{userId}/bookings")
public class SmartmoveReservationController {

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reservation> getReservations(@PathVariable("userId") String userId) {
    	return bookingRepository.findByUserId(userId);
    }
    
    @RequestMapping(value = "/{pnr}", method = RequestMethod.GET)
    public Reservation getReservationsForBookingId(@PathVariable("pnr") String pnr) {
        return bookingRepository.findByBookingId(pnr);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Reservation addBooking(@PathVariable("userId") String userId, @RequestBody  Reservation reservation) {
    	System.out.println(userId);
    	reservation.setUserId(userId);
    	bookingRepository.save(reservation);
    	reservation.setStatus("Success");
//    	try {
//    		boolean available = isBookingAvailable(bookingRepository.findByUserId(userId), reservation.getBookingCode());
//    		if (available == true) {
//    			reservation.setStatus("Booking already available");
//    		} else {
//    			Reservation reservationDomain = reservationService.retrieveBooking(reservation);
//    			System.out.println(reservationDomain.getUserId());
//	    		bookingRepository.save(reservationDomain);
//	    		reservation.setStatus("Success");
//    		}
//		} catch (Exception e) {
//			e.printStackTrace();
//			reservation.setStatus(e.getMessage());			
//		}
        return reservation;
    }
    
    private boolean isBookingAvailable(List<Reservation> bookings, String pnrTobeAdded) {
    	boolean flag = false;
		for (Reservation booking : bookings) {
			if (StringUtils.equalsIgnoreCase(pnrTobeAdded, booking.getBookingCode())) {
				flag = true;
				break;
			}
		}
		return flag;
    }
}

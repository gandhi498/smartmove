/**
 * 
 */
package com.smartmove.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartmove.domain.reservation.Reservation;


/**
 * @author TCS
 *
 */
@Repository
public interface BookingRepository extends MongoRepository<Reservation, String> {
    
	List<Reservation> findByUserId(String userId);
	
	Reservation findByBookingId(String pnr);
	
}
/**
 * 
 */
package com.smartmove.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartmove.domain.mock.data.MockFlight;


/**
 * @author TCS
 *
 */
@Repository
public interface MockFlightRepository extends MongoRepository<MockFlight, String> {

    List<MockFlight> findByMarketingFlight(String marketing_flight);
    
    List<MockFlight> findByOperatingFlight(String operating_flight);
}

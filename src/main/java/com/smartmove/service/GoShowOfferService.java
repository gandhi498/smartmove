/**
 * 
 */
package com.smartmove.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartmove.domain.mock.data.MockFlight;
import com.smartmove.domain.offers.Flight;
import com.smartmove.domain.offers.SmartMoveGoShowOffer;
import com.smartmove.mongodb.repository.MockFlightRepository;
import com.smartmove.util.DateTimeConversionUtil;

/**
 * @author TCS
 * 
 */
@Service
public class GoShowOfferService {

    @Autowired
    private MockFlightRepository mockFlightRepository;
    
    public boolean checkForGoshowEligibility(String pnr, String flightNumber) {
        List<MockFlight> lstMockFlights = mockFlightRepository.findByMarketingFlight(flightNumber);
        if (null == lstMockFlights || lstMockFlights.isEmpty()) {
            lstMockFlights = mockFlightRepository.findByOperatingFlight(flightNumber);
        }
        if (null != lstMockFlights && !lstMockFlights.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param pnr
     * @param flightNumber
     * @return
     *      the SmartMoveGoShowOffer
     */
    public SmartMoveGoShowOffer findGoShowOffer(String pnr, String flightNumber) {
        // IdentifyPassenger from DCS
        // If response Ok, then check for rules related as per DCS
        // Check for additinal eligibility for goshow as per carrier business rules
        // Call provide alternative flights
        SmartMoveGoShowOffer smartMoveGoShowOffer = new SmartMoveGoShowOffer();
        List<MockFlight> lstMockFlight = mockFlightRepository.findAll();
        List<MockFlight> lstBookedFlight = mockFlightRepository.findByMarketingFlight(flightNumber);
        if (null == lstBookedFlight) {
            lstBookedFlight = mockFlightRepository.findByOperatingFlight(flightNumber);
        }
        if (null != lstBookedFlight && lstBookedFlight.size() == 1) {
            MockFlight mckFlight = lstBookedFlight.get(0);
            Flight bookedFlight = new Flight();
            bookedFlight.setArrival(mckFlight.getDestination());
            bookedFlight.setDeparture(mckFlight.getOrigin());
            bookedFlight.setDepartureDate(mckFlight.getDepartureDateTime().toCalendar(Locale.US));
            bookedFlight.setJourneyTime(null);
            bookedFlight.setMarketedBy(mckFlight.getMarketingFlight());
            bookedFlight.setMarketingFlightNumber(mckFlight.getMarketingFlight());
            bookedFlight.setOperatedBy(mckFlight.getOperatingFlight());
            bookedFlight.setOperatingFlightNumber(mckFlight.getOperatingFlight());
            DateTime currentLocalTime = DateTimeConversionUtil.getCurrentTime(mckFlight.getOrigin_time_zone());
            List<Flight> alternativeFlights = new ArrayList<Flight>();
            for (MockFlight mockFlight : lstMockFlight) {
                if (mockFlight.getDepartureDateTime().isAfter(currentLocalTime) && !StringUtils.equals(mckFlight.getDeparture_time(), mockFlight.getDeparture_time())) {
                    Flight alternateFlight = new Flight();
                    alternateFlight.setArrival(mockFlight.getDestination());
                    alternateFlight.setDeparture(mockFlight.getOrigin());
                    alternateFlight.setDepartureDate(mockFlight.getDepartureDateTime().toCalendar(Locale.US));
                    alternateFlight.setJourneyTime(null);
                    alternateFlight.setMarketedBy(mockFlight.getMarketingFlight());
                    alternateFlight.setMarketingFlightNumber(mockFlight.getMarketingFlight());
                    alternateFlight.setOperatedBy(mockFlight.getOperatingFlight());
                    alternateFlight.setOperatingFlightNumber(mockFlight.getOperatingFlight());
                    alternativeFlights.add(alternateFlight);
                }
            }
            smartMoveGoShowOffer.setAlertnateFlights(alternativeFlights);
            smartMoveGoShowOffer.setBookedFlight(bookedFlight);
        }
        return smartMoveGoShowOffer;
    }
}

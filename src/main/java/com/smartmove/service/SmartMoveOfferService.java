package com.smartmove.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartmove.domain.common.SmartMoveLink;
import com.smartmove.domain.offers.AirportParkingOffer;
import com.smartmove.domain.offers.CheckinOffer;
import com.smartmove.domain.offers.GoShowOffer;
import com.smartmove.domain.offers.SmartMoveGoShowOffer;
import com.smartmove.domain.offers.SmartMoveOfferResponse;
import com.smartmove.domain.offers.SmartMoveOffersRequest;
import com.smartmove.domain.offers.UberOffer;
import com.smartmove.rest.controller.SmartMoveOfferController;
import com.smartmove.util.MockData;
import com.smartmove.util.StaticData;

/**
 * 
 * @author TCS
 * 
 */
@Service
public class SmartMoveOfferService {

    @Autowired
    private GoShowOfferService goShowOfferService;

    public SmartMoveOfferResponse getRelevantOffers(SmartMoveOffersRequest smartMoveOfferRequest, String userId) {
        SmartMoveOfferResponse smartMoveOfferResponse = new SmartMoveOfferResponse();
        String zone = determineZone(smartMoveOfferRequest.getEta());
        smartMoveOfferResponse.setZone(zone);
        determineRelevantOffers(smartMoveOfferRequest, smartMoveOfferResponse, userId);
        smartMoveOfferResponse.setAirportGPSLocationLat(smartMoveOfferRequest.getAirportGPSLocationLat());
        smartMoveOfferResponse.setAirportGPSLocationLong(smartMoveOfferRequest.getAirportGPSLocationLong());
        smartMoveOfferResponse.setDistance(smartMoveOfferRequest.getDistance());
        smartMoveOfferResponse.setEta(smartMoveOfferRequest.getEta());
        smartMoveOfferResponse.setFlightNumber(smartMoveOfferRequest.getFlightNumber());
        smartMoveOfferResponse.setMode(smartMoveOfferRequest.getMode());
        smartMoveOfferResponse.setUserGPSLocationLat(smartMoveOfferRequest.getUserGPSLocationLat());
        smartMoveOfferResponse.setUserGPSLocationLong(smartMoveOfferRequest.getUserGPSLocationLong());
        return smartMoveOfferResponse;
    }

    /**
     * Method determines Zone based on ETA. TODO: Mocked for now, It will be
     * updated with logic based on PNR and rule engine
     * 
     * @param eta
     *            int
     * @return Zone of customer
     */
    private String determineZone(int eta) {
        String zone = "unknown";
        // GREEN : ETA < 120 MINS (1.5 hours)
        // RED: ETA > 150 (i.e. 2.5 hrs)
        //YELLOW: between red and green is yellow (may or may not reach on time)
        
        if (eta < 120) {
            zone = StaticData.ZONE_GREEN;
        }       
        else if (eta > 180) {
            zone = StaticData.ZONE_RED;
        } 
        else 
        {
            zone = StaticData.ZONE_YELLOW;
        }
        return zone;
    }

    private void determineRelevantOffers(SmartMoveOffersRequest smartMoveOfferRequest, SmartMoveOfferResponse smartMoveOfferResponse, String userId) {
        GoShowOffer goShowOffer = null;
        CheckinOffer checkinOffer = null;
        AirportParkingOffer airportParkingOffer = null;
        
        UberOffer uber = null;// checkUberOffer(smartMoveOfferRequest, userId);
        
        if (StringUtils.endsWithIgnoreCase(smartMoveOfferResponse.getZone(), StaticData.ZONE_RED)) {            
            goShowOffer = checkGoShowOffer(smartMoveOfferRequest, userId);        

            smartMoveOfferResponse.addOffer(goShowOffer);

        }
        else if (StringUtils.endsWithIgnoreCase(smartMoveOfferResponse.getZone(), StaticData.ZONE_GREEN)) {
            // check for alternate flights eligibility
        	checkinOffer = checkCheckinOffer(smartMoveOfferRequest, userId);
        	goShowOffer = checkGoShowOffer(smartMoveOfferRequest, userId);            
            airportParkingOffer = checkAirportOffer(smartMoveOfferRequest, userId);
            smartMoveOfferResponse.addOffer(airportParkingOffer);
            smartMoveOfferResponse.addOffer(goShowOffer);
            smartMoveOfferResponse.addOffer(checkinOffer);
            
        }
        else if (StringUtils.endsWithIgnoreCase(smartMoveOfferResponse.getZone(), StaticData.ZONE_YELLOW)) {
            uber = checkUberOffer(smartMoveOfferRequest, userId);
            checkinOffer = checkCheckinOffer(smartMoveOfferRequest, userId);

            smartMoveOfferResponse.addOffer(uber);
            smartMoveOfferResponse.addOffer(checkinOffer);

        }
        
        if (null != airportParkingOffer) {
        	smartMoveOfferResponse.addOffer(airportParkingOffer);
        }

    }

    private UberOffer checkUberOffer(SmartMoveOffersRequest smartMoveOfferRequest, String userId) {
        return MockData.getUberOffer(smartMoveOfferRequest);
    }

    private AirportParkingOffer checkAirportOffer(SmartMoveOffersRequest smartMoveOfferRequest, String userId) {
        return MockData.getAirportParking(smartMoveOfferRequest);
    }

    private CheckinOffer checkCheckinOffer(SmartMoveOffersRequest smartMoveOfferRequest, String userId) {
        return MockData.getCheckinOffer(smartMoveOfferRequest);
    }

    private GoShowOffer checkGoShowOffer(SmartMoveOffersRequest smartMoveOfferRequest, String userId) {
        GoShowOffer goShowOffer = null;
        boolean goShowEligbility = goShowOfferService.checkForGoshowEligibility(smartMoveOfferRequest.getPnr(), smartMoveOfferRequest.getFlightNumber());
        if (goShowEligbility) {
            goShowOffer = new GoShowOffer();
            goShowOffer.setFlightNumber(smartMoveOfferRequest.getFlightNumber());
            goShowOffer.setOfferAvailable(true);
            goShowOffer.setOfferDesc("Coming too late or too early? We have flights at each hour!");
            goShowOffer.setOfferName("Alternate Flights");
            goShowOffer.setUserId(userId);
            goShowOffer.setOfferTitle("Alternate Flights");
            goShowOffer.setPnr(smartMoveOfferRequest.getPnr());
            //goShowOffer.add(linkTo(methodOn(SmartMoveOfferController.class).getGoShowOffer(userId, smartMoveOfferRequest.getPnr(), smartMoveOfferRequest.getFlightNumber())).withSelfRel());
            goShowOffer.add(new SmartMoveLink(linkTo(methodOn(SmartMoveOfferController.class).getGoShowOffer(userId, smartMoveOfferRequest.getPnr(), smartMoveOfferRequest.getFlightNumber())).withSelfRel().getHref(), "goshow", "images/alternate_flights_icon.png"));
            
        }
        return goShowOffer;
    }

    public SmartMoveGoShowOffer findGoShowOffer(String pnr, String flightNumber) {
        SmartMoveGoShowOffer  smartMoveGoShowOffer  = goShowOfferService.findGoShowOffer(pnr, flightNumber);
        return smartMoveGoShowOffer;
    }

}

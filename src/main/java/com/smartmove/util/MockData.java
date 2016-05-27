/**
 * 
 */
package com.smartmove.util;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.smartmove.domain.common.SmartMoveLink;
import com.smartmove.domain.offers.AirportParkingOffer;
import com.smartmove.domain.offers.CheckinOffer;
import com.smartmove.domain.offers.RelevantOffer;
import com.smartmove.domain.offers.SmartMoveOffersRequest;
import com.smartmove.domain.offers.UberOffer;
import com.smartmove.rest.controller.SmartMoveOfferController;

/**
 * @author x085085
 * 
 */
public final class MockData {

    private static String LINK_UBER = "https://www.uber.com/fares/latLngEstimate?start_latitude={0}&start_longitude={1}&end_latitude={2}&end_longitude={3}&vids[]=1270&vids[]=64&vids[]=343";
    private static String LINK_AIRPORT_PARKING = "https://www.klm.com/travel/nl_en/plan_and_book/hotels_cars_and_more/about_renting_a_car/parking.htm?For=Airport,{0}&DateRange={1}";

    public static RelevantOffer getAlternateFlightOffer() {
        String offerName = RelevantOffer.relevantOfferName.ALTERNATE_FLIGHT.toString();
        RelevantOffer relavantOffer = new RelevantOffer();
        relavantOffer.setOfferName(offerName);
        relavantOffer.setOfferTitle("Alternate Flight");
        relavantOffer.setOfferDesc("Checkin to an alternate flight.");
        relavantOffer.getLinks().add(new SmartMoveLink("http", "_" + offerName, "images/alternate_flights_icon.png"));
        return relavantOffer;
    }

    public static UberOffer getUberOffer(SmartMoveOffersRequest offersRequest) {
        String offerName = RelevantOffer.relevantOfferName.UBER.toString();
        UberOffer uber = new UberOffer();
        uber.setOfferAvailable(true);
        uber.setOfferName(offerName);
        uber.setOfferTitle("UBER Taxi");
        uber.setOfferDesc("Arrive on time");
        String[] args = {offersRequest.getUserGPSLocationLat(), offersRequest.getUserGPSLocationLong(), offersRequest.getAirportGPSLocationLat(), offersRequest.getAirportGPSLocationLong()};
        //SmartMoveLink link = new SmartMoveLink(MessageFormat.format(LINK_UBER, args), offerName, "images/uber_taxi_icon.png");
        uber.add(new SmartMoveLink(linkTo(methodOn(SmartMoveOfferController.class).getuberFares("userId", offersRequest.getUserGPSLocationLat(), offersRequest.getAirportGPSLocationLong(), offersRequest.getAirportGPSLocationLat(), offersRequest.getAirportGPSLocationLong())).withSelfRel().getHref(), "Uber", "images/uber_taxi_icon.png"));
        //uber.add(link);
        return uber;
    }

    public static AirportParkingOffer getAirportParking(SmartMoveOffersRequest offersRequest) {
        AirportParkingOffer airportParkingOffer = new AirportParkingOffer();
        airportParkingOffer.setOfferAvailable(true);
        String offerName = RelevantOffer.relevantOfferName.AIRPORT_PARKING.toString();
        airportParkingOffer.setOfferName(offerName);
        airportParkingOffer.setOfferTitle("Airport Parking");
        airportParkingOffer.setOfferDesc("Find a parking");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        String[] args = {"AMS", date}; 
        SmartMoveLink link = new SmartMoveLink(MessageFormat.format(LINK_AIRPORT_PARKING, args), offerName, "images/airport_parking_icon.png");
        airportParkingOffer.add(link);
        return airportParkingOffer;
    }


    public static CheckinOffer getCheckinOffer(SmartMoveOffersRequest offersRequest) {
        String offerName = RelevantOffer.relevantOfferName.CHECK_IN.toString();
        CheckinOffer checkin = new CheckinOffer();
        checkin.setOfferAvailable(true);
        checkin.setOfferName(offerName);
        checkin.setOfferTitle("Checkin"); 
        checkin.setOfferDesc("Select your seat");
        SmartMoveLink link = new SmartMoveLink("https://www.klm.com/ams/checkin/web/kl/nl/en", offerName, "images/flight_icon.png");
        checkin.add(link);
        return checkin;
    }
    
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        System.out.println(date);
    }
}

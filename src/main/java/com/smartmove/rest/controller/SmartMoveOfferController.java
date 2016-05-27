/**
 * 
 */
package com.smartmove.rest.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartmove.domain.offers.SmartMoveGoShowOffer;
import com.smartmove.domain.offers.SmartMoveOfferResponse;
import com.smartmove.domain.offers.SmartMoveOffersRequest;
import com.smartmove.domain.offers.Uber;
import com.smartmove.service.SmartMoveOfferService;
import com.smartmove.service.UberService;

/**
 * @author TCS
 * 
 */
@RestController
@RequestMapping("/users/{userId}")
public class SmartMoveOfferController {
    
    @Autowired
    private SmartMoveOfferService smartMoveOfferService;
    
    @Autowired
    private UberService uberService;
    
    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(SmartMoveOfferController.class);
    
    @RequestMapping(value = "/offers", method=RequestMethod.POST)
    public SmartMoveOfferResponse getOffers(@PathVariable("userId") String userId, @RequestBody SmartMoveOffersRequest smartMoveOffers) {
        LOG.debug("getting offers for smart move user {} and eta {}", userId, smartMoveOffers.getEta());
        return smartMoveOfferService.getRelevantOffers(smartMoveOffers, userId);
    }
    
    @RequestMapping(value = "/offers/goshow/pnr/{pnr}/flight/{flightNumber}", method=RequestMethod.POST)
    public SmartMoveGoShowOffer getGoShowOffer(@PathVariable("userId") String userId, @PathVariable("pnr") String pnr, @PathVariable("flightNumber") String flightNumber) {
        LOG.debug("getting goshow offer for smart move user {}", pnr);
        return smartMoveOfferService.findGoShowOffer(pnr, flightNumber);
    }
    
    @RequestMapping(value = "/offers/uber/start_latitude/{start_latitude}/start_longitude/{start_longitude}/end_latitude/{end_latitude}/end_longitude/{end_longitude}/fare", method=RequestMethod.GET)
    public Uber getuberFares(@PathVariable("userId") String userId, @PathVariable("start_latitude") String start_latitude, @PathVariable("start_longitude") String start_longitude, @PathVariable("end_latitude") String end_latitude, @PathVariable("end_longitude") String end_longitude) {
        Uber uber = null;
        LOG.debug("getting uber offer for smart move user {}", userId);
        String response = StringUtils.EMPTY;
        try {
            response = uberService.getFare(start_latitude, start_longitude, end_latitude, end_longitude);
            uber = objectMapper.readValue(response, Uber.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uber;
    }
}

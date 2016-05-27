/**
 * 
 */
package com.smartmove.domain.offers;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author TCS
 * 
 */
public class RelevantOffer extends ResourceSupport {

    public static enum relevantOfferName {
        CHECK_IN,
        TAXI,
        ALTERNATE_FLIGHT,
        UBER,
        LOUNGE,
        AIRPORT_PARKING
    };

    private String offerName;
    private String offerType;

    private String offerTitle;
    private String offerDesc;
    private String imageUrl;
    private boolean offerAvailable;
    
    @JsonIgnore
    private String userId;
   /* private List<SmartMoveLink> links;*/

    /**
     * @return the offerTitle
     */
    public String getOfferTitle() {
        return offerTitle;
    }

    /**
     * @param offerTitle
     *            the offerTitle to set
     */
    public void setOfferTitle(String offerTitle) {
        this.offerTitle = offerTitle;
    }

    /**
     * @return the offerDesc
     */
    public String getOfferDesc() {
        return offerDesc;
    }

    /**
     * @param offerDesc
     *            the offerDesc to set
     */
    public void setOfferDesc(String offerDesc) {
        this.offerDesc = offerDesc;
    }

    /**
     * @return the offerName
     */
    public String getOfferName() {
        return offerName;
    }

    /**
     * @param offerName
     *            the offerName to set
     */
    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    /**
     * @return the offerType
     */
    public String getOfferType() {
        return offerType;
    }

    /**
     * @param offerType
     *            the offerType to set
     */
    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    /**
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl
     *            the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return the links
     *//*
    public List<SmartMoveLink> getLinks() {
        if (null == links) {
            links = new ArrayList<SmartMoveLink>();
        }
        return links;
    }
*/
    /**
     * @param links
     *            the links to set
     *//*
    public void setLinks(List<SmartMoveLink> links) {
        this.links = links;
    }
*/
    
    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public boolean isOfferAvailable() {
        return offerAvailable;
    }
    
    public void setOfferAvailable(boolean offerAvailable) {
        this.offerAvailable = offerAvailable;
    }

}

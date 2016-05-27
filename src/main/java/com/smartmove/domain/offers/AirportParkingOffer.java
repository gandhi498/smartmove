/**
 * 
 */
package com.smartmove.domain.offers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.smartmove.domain.common.SmartMoveLink;

/**
 * @author TCS
 * 
 */
@JsonInclude(Include.NON_EMPTY)
public class AirportParkingOffer extends RelevantOffer {

    private SmartMoveLink link;

    public SmartMoveLink getLink() {
        return link;
    }

    public void setLink(SmartMoveLink link) {
        this.link = link;
    }
}

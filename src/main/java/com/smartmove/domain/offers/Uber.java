/**
 * 
 */
package com.smartmove.domain.offers;

import java.util.List;


/**
 * @author TCS
 *
 */
public class Uber {
    private List<Estimates> estimates;

    
    public List<Estimates> getEstimates() {
        return estimates;
    }

    
    public void setEstimates(List<Estimates> estimates) {
        this.estimates = estimates;
    }
}

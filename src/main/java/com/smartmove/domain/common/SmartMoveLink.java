/**
 * 
 */
package com.smartmove.domain.common;

import org.springframework.hateoas.Link;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * @author TCS
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class SmartMoveLink extends Link {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String resourceHref;
    private String rel;
    private String imageUrl;
    
    public SmartMoveLink(String resourceHref, String rel, String imageUrl) {
        super();
        this.resourceHref = resourceHref;
        this.rel = rel;
        this.imageUrl = imageUrl;
    }

    public String getRel() {
        return rel;
    }
    
    public void setRel(String rel) {
        this.rel = rel;
    }
    
    public String getResourceHref() {
        return resourceHref;
    }

    
    public void setResourceHref(String resourceHref) {
        this.resourceHref = resourceHref;
    }

    
    public String getImageUrl() {
        return imageUrl;
    }

    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    
}

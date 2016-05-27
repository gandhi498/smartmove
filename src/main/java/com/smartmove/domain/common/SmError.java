/**
 * 
 */
package com.smartmove.domain.common;


/**
 * @author TCS
 *
 */
public class SmError {

    private String errorCode;
    private String errorText;
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    public String getErrorText() {
        return errorText;
    }
    
    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}

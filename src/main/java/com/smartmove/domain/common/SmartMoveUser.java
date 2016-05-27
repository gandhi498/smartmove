/**
 * 
 */
package com.smartmove.domain.common;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author TCS
 * 
 */
@JsonInclude(Include.NON_EMPTY)
public class SmartMoveUser extends ResourceSupport {

    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String appToken;
    private String deviceType;
    private String myAccountId;
    private String frequentFlyerId;
    private boolean smartMoveActive;

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getMyAccountId() {
        return myAccountId;
    }

    public void setMyAccountId(String myAccountId) {
        this.myAccountId = myAccountId;
    }

    public String getFrequentFlyerId() {
        return frequentFlyerId;
    }

    public void setFrequentFlyerId(String frequentFlyerId) {
        this.frequentFlyerId = frequentFlyerId;
    }

    public boolean isSmartMoveActive() {
        return smartMoveActive;
    }

    public void setSmartMoveActive(boolean smartMoveActive) {
        this.smartMoveActive = smartMoveActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public static SmartMoveUser getUpdated(SmartMoveUser smartMoveUser, SmartMoveUser dbSmartMoveUser) {
        if (null != smartMoveUser.getEmail() && !StringUtils.equals(smartMoveUser.getEmail(), dbSmartMoveUser.getEmail())) {
            dbSmartMoveUser.setEmail(smartMoveUser.getEmail());
        }
        if (null != smartMoveUser.getFirstName() && !StringUtils.equals(smartMoveUser.getFirstName(), dbSmartMoveUser.getFirstName())) {
            dbSmartMoveUser.setFirstName(smartMoveUser.getFirstName());
        }
        if (null != smartMoveUser.getLastName() && !StringUtils.equals(smartMoveUser.getLastName(), dbSmartMoveUser.getLastName())) {
            dbSmartMoveUser.setLastName(smartMoveUser.getLastName());
        }
        if (null != smartMoveUser.getAppToken() && !StringUtils.equals(smartMoveUser.getAppToken(), dbSmartMoveUser.getAppToken())) {
            dbSmartMoveUser.setAppToken(smartMoveUser.getAppToken());
        }
        if (null != smartMoveUser.getMyAccountId() && !StringUtils.equals(smartMoveUser.getMyAccountId(), dbSmartMoveUser.getMyAccountId())) {
            dbSmartMoveUser.setMyAccountId(smartMoveUser.getMyAccountId());
        }
        if (null != smartMoveUser.getDeviceType() && !StringUtils.equals(smartMoveUser.getDeviceType(), dbSmartMoveUser.getDeviceType())) {
            dbSmartMoveUser.setDeviceType(smartMoveUser.getDeviceType());
        }

        if (null != smartMoveUser.getFrequentFlyerId() && !StringUtils.equals(smartMoveUser.getFrequentFlyerId(), dbSmartMoveUser.getFrequentFlyerId())) {
            dbSmartMoveUser.setFrequentFlyerId(smartMoveUser.getFrequentFlyerId());
        }
        return dbSmartMoveUser;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}

/**
 * 
 */
package com.smartmove.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smartmove.domain.common.SmartMoveUser;
import com.smartmove.mongodb.repository.SmartMoveuserRespository;
import com.smartmove.rest.controller.SmartMoveUserController;

/**
 * @author TCS
 * 
 */
@Component
public class SmartMoveUserService {

    @Autowired
    private SmartMoveuserRespository smartMoveuserRespository;

    public List<SmartMoveUser> getSmartMoveUsers() {
        return smartMoveuserRespository.findAll();
    }

    public void registerUser(SmartMoveUser smartMoveUser) {
        smartMoveuserRespository.save(smartMoveUser);
        smartMoveUser.add(linkTo(methodOn(SmartMoveUserController.class).getUser(smartMoveUser.getUserId())).withSelfRel());
    }

    public SmartMoveUser getSmartmoveUser(String userId) {
        SmartMoveUser smartMoveUser = smartMoveuserRespository.findOne(userId);
        smartMoveUser.add(linkTo(methodOn(SmartMoveUserController.class).getUser(smartMoveUser.getUserId())).withSelfRel());
        return smartMoveUser;
    }

}

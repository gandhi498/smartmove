/**
 * 
 */
package com.smartmove.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartmove.domain.common.SmartMoveUser;
import com.smartmove.service.SmartMoveUserService;

/**
 * @author TCS
 * 
 */
@RestController
@RequestMapping("/users")
public class SmartMoveUserController {

    private static final Logger LOG = LoggerFactory.getLogger(SmartMoveUserController.class);

    @Autowired
    private SmartMoveUserService smartMoveUserService;

    @RequestMapping(method = RequestMethod.GET)
    public List<SmartMoveUser> getAllRegisteredUsers() {
        LOG.debug("finding all smartmove users list");
        return smartMoveUserService.getSmartMoveUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public SmartMoveUser getUser(@PathVariable("userId") String userId) {
        LOG.debug("finding smartmove users with id {}", userId);
        SmartMoveUser smartMoveUser = smartMoveUserService.getSmartmoveUser(userId);
        return smartMoveUser;
    }

    @RequestMapping(method = RequestMethod.POST)
    public SmartMoveUser register(@RequestBody SmartMoveUser smartMoveUser) {
        smartMoveUserService.registerUser(smartMoveUser);
        return smartMoveUser;
    }
}

/**
 *
 */
package com.smartmove.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author TCS
 *
 */
@Controller
@RequestMapping(value="/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String showWelcomePage() {
        return "sm_mobile_index";
    }
}

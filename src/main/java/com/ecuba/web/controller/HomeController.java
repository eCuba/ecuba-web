package com.ecuba.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rolando on 14-08-15.
 */

@Controller
public class HomeController {
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("app/home");
    }
}

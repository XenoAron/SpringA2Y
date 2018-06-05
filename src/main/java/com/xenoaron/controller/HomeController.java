package com.xenoaron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @메쏘드명 : HomeController
 * @작성자 : jwt1029
 * @작성일자 : 2018-06-05
 * @설명 :
 */
@Controller
public class HomeController {
    /*
    * '@ResponseBody' return *HTTP Response Body* not through *View*
    * (like json, xml, string, etc.)
    * */
    @ResponseBody
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello() {
        return "Hello";
    }

    /*
    * If you don't use '@ResponseBody', it will return 'View' named "home"
    * (refer to 'root-context.xml')
    * */
    @RequestMapping(value = "/home")
    public String loadHomePage() {
        return "home";
    }
}

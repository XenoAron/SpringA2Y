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
    @ResponseBody
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello() {
        return "Hello";
    }
}

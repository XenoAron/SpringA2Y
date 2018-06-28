package com.xenoaron.controller;

import com.xenoaron.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @메쏘드명 : HomeController
 * @작성자 : jwt1029
 * @작성일자 : 2018-06-05
 * @설명 :
 */
@Controller
public class HomeController {

    // Using @Autowired annotation to sharing Service component (Singleton)
    @Autowired
    private HomeService homeService;

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

    /*
     * You can use other response type if you use jackson-databind library (see pom.xml)
     * Boolean -> String convert
     * */
    @ResponseBody
    @RequestMapping(value = "/getBoolean")
    public Boolean getBoolean() {
        return true;
    }

    /*
     * Using @RequestParam annotation when receive parameters from client.
     * Using Service and make business logic in it.
     * */
    @ResponseBody
    @RequestMapping(value = "/addNumbers", method = {RequestMethod.GET})
    public Integer addNumbers(
            @RequestParam(value = "num1") Integer number1       // Client side parameter name : num1 / Server side parameter name : number1
            ,@RequestParam(value = "num2") Integer number2
            ,@RequestParam(value = "num3", required = false, defaultValue = "0") Integer number3    // 'number3' parameter is not necessary parameter
    ) {
        Integer sum = homeService.addNumber(number1, number2);  // get sum value through Service
        sum = homeService.addNumber(sum, number3);
        return sum;
    }
}

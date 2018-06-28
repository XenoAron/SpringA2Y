package com.xenoaron.service;

import org.springframework.stereotype.Service;

/**
 * @메쏘드명 : HomeService
 * @작성자 : jwt1029
 * @작성일자 : 2018-06-28
 * @설명 :
 */
@Service
public class HomeService {

    // return sum of two number
    public Integer addNumber(Integer number1, Integer number2) {
        return number1 + number2;
    }
}

package com.ab.app_for_a_b.controller;

import com.ab.app_for_a_b.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/rate")
public class ExchangeRatesController {

    @Autowired
    private ExchangeRateService  exchangeRateService;

    @GetMapping(value = "/yesterday"
            ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Map<String, String>> getYesterdayExchangeRate() {
        Map<String, String> yesterdayExchangeRate = exchangeRateService.getYesterdayExchangeRate();
        if(!yesterdayExchangeRate.isEmpty()){
            return ResponseEntity.ok().body(yesterdayExchangeRate);
        }
        else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/latest"
            ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Map<String, String>> getLatestExchangeRate() {
        Map<String, String> latestExchangeRate = exchangeRateService.getLatestExchangeRate();
        if(!latestExchangeRate.isEmpty()){
            return ResponseEntity.ok().body(latestExchangeRate);
        }
        else {
            return ResponseEntity.internalServerError().build();
        }
    }
}

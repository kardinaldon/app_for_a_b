package com.ab.app_for_a_b.service;

import com.ab.app_for_a_b.client.ExchangeRateClient;
import com.ab.app_for_a_b.model.exchangeRate.ExchangeRateModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateClient exchangeRateClient;

    public Map<String, String> getYesterdayExchangeRate() {
        Map<String, String> result = new HashMap<String, String>();
        String date = LocalDate.now().minusDays(1).toString();
        try {
            ResponseEntity<ExchangeRateModel> yesterdayExchangeRate
                    = exchangeRateClient.getYesterdayExchangeRate(date);
            ExchangeRateModel yesterdayExchangeRateBody = yesterdayExchangeRate.getBody();
            result.put("rate", yesterdayExchangeRateBody.getRates().get("RUB").toString());
            result.put("date", date);
            return result;
        }
        catch (Exception ex) {
            log.error("An exception occurred!", new Exception(ex));
            return result;
        }

    }

    public Map<String, String> getLatestExchangeRate() {
        Map<String, String> result = new HashMap<String, String>();
        String date = LocalDate.now().toString();
        try {
            ResponseEntity<ExchangeRateModel> latestExchangeRate
                    = exchangeRateClient.getLatestExchangeRate();
            ExchangeRateModel latestExchangeRateBody = latestExchangeRate.getBody();
            result.put("rate", latestExchangeRateBody.getRates().get("RUB").toString());
            result.put("date", date);
            return result;
        }
        catch (Exception ex) {
            log.error("An exception occurred!", new Exception(ex));
            return result;
        }
    }
}

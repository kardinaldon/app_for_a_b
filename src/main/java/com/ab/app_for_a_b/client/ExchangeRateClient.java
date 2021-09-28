package com.ab.app_for_a_b.client;

import com.ab.app_for_a_b.model.exchangeRate.ExchangeRateModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "clientExchangeRates", url = "${url.exchange_rates.main}")
public interface ExchangeRateClient {

    @GetMapping("${url.exchange_rates.last_prefix}"
            +"{date}"
            +"${url.exchange_rates.base_params}")
    ResponseEntity<ExchangeRateModel> getYesterdayExchangeRate(@PathVariable("date") String date);


    @GetMapping("${url.exchange_rates.latest_prefix}"+"${url.exchange_rates.base_params}")
    ResponseEntity<ExchangeRateModel> getLatestExchangeRate();

}

package com.ab.app_for_a_b.model.exchangeRate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Map;

@Data
public class ExchangeRateModel {

    @JsonProperty("disclaimer")
    private  String disclaimer;

    @JsonProperty("license")
    private URL license;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("base")
    private  String base;

    @JsonProperty("rates")
    private Map<String, BigDecimal> rates;

}


package com.ab.app_for_a_b.service;

import com.ab.app_for_a_b.client.ExchangeRateClient;
import com.ab.app_for_a_b.client.GiphyClient;
import com.ab.app_for_a_b.model.exchangeRate.ExchangeRateModel;
import com.ab.app_for_a_b.model.giphy.GiphyModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Service
public class GifService {

    @Autowired
    private ExchangeRateClient exchangeRateClient;

    @Autowired
    private GiphyClient giphyClient;

    private ExchangeRateModel latestExchangeRateModel = new ExchangeRateModel();
    private ExchangeRateModel yesterdayExchangeRateModel = new ExchangeRateModel();
    private GiphyModel giphyModel;

    public Optional<GiphyModel> getGif(){
        try {
            Optional<Boolean> compare = compareExchangeRates();
            if (!compare.isEmpty()) {
                giphyModel = compareExchangeRates().get()
                        ? giphyClient.getRichGif().getBody() : giphyClient.getBrokeGif().getBody();
                return Optional.of(giphyModel);
            }
            else {
                return Optional.empty();
            }
        }
        catch (Exception ex) {
            log.error("An exception occurred!", new Exception(ex));
            return Optional.empty();
        }
    }

    private Optional<Boolean> compareExchangeRates() {
        try {
            latestExchangeRateModel = exchangeRateClient.getLatestExchangeRate().getBody();
            yesterdayExchangeRateModel = exchangeRateClient
                    .getYesterdayExchangeRate(LocalDate.now().minusDays(1).toString()).getBody();
            BigDecimal latestExchangeRate = latestExchangeRateModel.getRates().get("RUB");
            BigDecimal yesterdayExchangeRate = yesterdayExchangeRateModel.getRates().get("RUB");
            return Optional.of(latestExchangeRate.compareTo(yesterdayExchangeRate) >= 0 ? true : false);
        }
        catch (Exception ex) {
            log.error("An exception occurred!", new Exception(ex));
            return Optional.empty();
        }
    }
}

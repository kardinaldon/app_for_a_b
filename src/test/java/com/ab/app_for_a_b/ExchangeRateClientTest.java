package com.ab.app_for_a_b;

import com.ab.app_for_a_b.client.ExchangeRateClient;
import com.ab.app_for_a_b.model.exchangeRate.ExchangeRateModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@SpringBootTest
public class ExchangeRateClientTest {

    private ExchangeRateModel exchangeRateModel = new ExchangeRateModel();

    @Mock
    private ExchangeRateClient client;

    @Test
    void getYesterdayExchangeRate() {
        Mockito.when(client.getYesterdayExchangeRate(LocalDate.now().minusDays(1).toString()))
                .thenReturn(new ResponseEntity(exchangeRateModel, HttpStatus.OK));
    }

    @Test
    void getLatestExchangeRate() {
        Mockito.when(client.getLatestExchangeRate())
                .thenReturn(new ResponseEntity(exchangeRateModel, HttpStatus.OK));
    }
}

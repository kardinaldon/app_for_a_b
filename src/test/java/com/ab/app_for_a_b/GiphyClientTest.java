package com.ab.app_for_a_b;

import com.ab.app_for_a_b.client.GiphyClient;
import com.ab.app_for_a_b.model.giphy.GiphyModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class GiphyClientTest {

    private GiphyModel giphyModel = new GiphyModel();

    @Mock
    private GiphyClient client;

    @Test
    void getRichGif() {
        Mockito.when(client.getRichGif())
                .thenReturn(new ResponseEntity(giphyModel, HttpStatus.OK));
    }

    @Test
    void getBrokeGif() {
        Mockito.when(client.getBrokeGif())
                .thenReturn(new ResponseEntity(giphyModel, HttpStatus.OK));
    }
}


package com.ab.app_for_a_b.client;

import com.ab.app_for_a_b.model.giphy.GiphyModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "clientGiphy", url = "${url.giphy.main}")
public interface GiphyClient {

    @GetMapping("${url.giphy.rich}"+"${url.giphy.api_id}")
    ResponseEntity<GiphyModel> getRichGif();


    @GetMapping("${url.giphy.broke}"+"${url.giphy.api_id}")
    ResponseEntity<GiphyModel> getBrokeGif();

}

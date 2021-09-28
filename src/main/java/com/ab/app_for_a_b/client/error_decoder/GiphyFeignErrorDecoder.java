package com.ab.app_for_a_b.client.error_decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GiphyFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()){
            case 400:
                log.error("Your request was formatted incorrectly or missing a required parameter(s)");
            case 429:
                log.error("Your API Key is making too many requests. Read about requesting a Production Key to upgrade your API Key rate limits");
            case 403:
                log.error("You weren't authorized to make your request; most likely this indicates an issue with your API Key");
            case 404:
                log.error("The particular GIF or Sticker you are requesting was not found. This occurs, for example, if you request a GIF by using an id that does not exist");
            default:
                return new Exception(response.reason());
        }
    }
}

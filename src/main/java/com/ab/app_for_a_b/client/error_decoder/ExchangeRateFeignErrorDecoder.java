package com.ab.app_for_a_b.client.error_decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExchangeRateFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()){
            case 400:
                log.error("Client requested rates for an unsupported base currency");
            case 401:
                log.error("Client provided an invalid App ID");
            case 429:
                log.error("Client doesn’t have permission to access requested route/feature");
            case 403:
                log.error("Access restricted for repeated over-use");
            case 404:
                log.error("Client requested a non-existent resource/route");
            default:
                return new Exception(response.reason());
        }
    }

}

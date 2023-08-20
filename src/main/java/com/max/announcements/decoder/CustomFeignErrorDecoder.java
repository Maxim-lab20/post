package com.max.announcements.decoder;

import com.max.announcements.exception.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String requestUrl = response.request().url();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        if (HttpStatus.BAD_REQUEST == responseStatus) {
            String errorMessage = String.format("bad request when calling %s", requestUrl);
            return new FeignException(errorMessage, responseStatus);
        }
        if (HttpStatus.NOT_FOUND == responseStatus) {
            String errorMessage = String.format("%s not found", requestUrl);
            return new FeignException(errorMessage, responseStatus);
        } else {
            return new Exception("Generic exception");
        }
    }

}
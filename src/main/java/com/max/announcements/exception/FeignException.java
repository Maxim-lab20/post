package com.max.announcements.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class FeignException extends RuntimeException {

    private final String message;
    private final HttpStatus status;

}

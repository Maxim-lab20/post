package com.max.announcements.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {

        String errorMessage = "An error occurred.";

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorMessage);
    }

    @ExceptionHandler(AnnouncementNotFoundException.class)
    public ResponseEntity<String> handleAnnouncementNotFoundException(AnnouncementNotFoundException ex) {

        String errorMessage = "An error occurred: " + ex.getMessage();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorMessage);
    }

}

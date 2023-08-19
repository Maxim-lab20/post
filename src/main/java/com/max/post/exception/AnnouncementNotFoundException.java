package com.max.post.exception;

public class AnnouncementNotFoundException extends RuntimeException {

    public AnnouncementNotFoundException(String message) {
        super(message);
    }

    public AnnouncementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

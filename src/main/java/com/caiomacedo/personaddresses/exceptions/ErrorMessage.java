package com.caiomacedo.personaddresses.exceptions;

import java.time.LocalDateTime;

public class ErrorMessage {

    private final String message;
    private final LocalDateTime timestamp;

    public ErrorMessage(String message){
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

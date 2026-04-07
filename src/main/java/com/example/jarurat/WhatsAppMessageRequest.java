package com.example.jarurat;

import jakarta.validation.constraints.NotBlank;

public class WhatsAppMessageRequest {

    @NotBlank(message = "must not be empty")
    private String message;

    public WhatsAppMessageRequest() {
    }

    public WhatsAppMessageRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

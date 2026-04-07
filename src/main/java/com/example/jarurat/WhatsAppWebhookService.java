package com.example.jarurat;

import org.springframework.stereotype.Service;

@Service
public class WhatsAppWebhookService {

    public String generateReply(String incomingMessage) {
        String normalizedMessage = incomingMessage.trim();

        // Keep the chatbot rules explicit so the behavior is easy to extend later.
        if ("Hi".equalsIgnoreCase(normalizedMessage)) {
            return "Hello, How Are You";
        }

        if ("Bye".equalsIgnoreCase(normalizedMessage)) {
            return "Goodbye, See You";
        }

        return "Wrong input";
    }
}

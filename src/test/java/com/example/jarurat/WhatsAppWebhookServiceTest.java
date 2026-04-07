package com.example.jarurat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class WhatsAppWebhookServiceTest {

    private final WhatsAppWebhookService whatsAppWebhookService = new WhatsAppWebhookService();

    @Test
    void WhenSayHai() {
        assertEquals("Hello, How Are You", whatsAppWebhookService.generateReply("Hi"));
    }

    @Test
    void WhenSayHaiBye() {
        assertEquals("Goodbye, See You", whatsAppWebhookService.generateReply("Bye"));
    }

    @Test
    void WhenSayUnknownInput() {
        assertEquals("Wrong input", whatsAppWebhookService.generateReply("How are you?"));
    }

    @Test
    void WhenUseIgnoreCaseAndWhitespace() {
        assertEquals("Hello, How Are You", whatsAppWebhookService.generateReply("  hi  "));
    }
}

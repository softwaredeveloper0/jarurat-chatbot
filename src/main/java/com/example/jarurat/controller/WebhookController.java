package com.example.jarurat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jarurat.WhatsAppMessageRequest;
import com.example.jarurat.dto.Response;
import com.example.jarurat.service.WhatsAppWebhookService;

import jakarta.validation.Valid;

@RestController
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private final WhatsAppWebhookService whatsAppWebhookService;

    public WebhookController(WhatsAppWebhookService whatsAppWebhookService) {
        this.whatsAppWebhookService = whatsAppWebhookService;
        
    }

    @PostMapping("/webhook")
    public ResponseEntity<Response> receiveWebhook(@Valid @RequestBody WhatsAppMessageRequest request) {
        logger.info("Incoming webhook message='{}'", request.getMessage());

        String reply = whatsAppWebhookService.generateReply(request.getMessage());
        return ResponseEntity.ok(new Response(reply));
    }

    @GetMapping("/webhook")
    public ResponseEntity<Response> handleGet(@Valid @RequestParam String message) {
        logger.info("Incoming webhook message='{}'", message);

        String reply = whatsAppWebhookService.generateReply(message);
        return ResponseEntity.ok(new Response(reply));
    }
}

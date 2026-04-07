package com.example.jarurat;

import com.example.jarurat.dto.ApiResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private final WhatsAppWebhookService whatsAppWebhookService;

    public WebhookController(WhatsAppWebhookService whatsAppWebhookService) {
        this.whatsAppWebhookService = whatsAppWebhookService;
    }

    @PostMapping("/webhook")
    public ResponseEntity<ApiResponse> receiveWebhook(@Valid @RequestBody WhatsAppMessageRequest request) {
        logger.info("Incoming webhook message='{}'", request.getMessage());

        String reply = whatsAppWebhookService.generateReply(request.getMessage());
        return ResponseEntity.ok(new ApiResponse(reply));
    }
}

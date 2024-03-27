package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.dto.MailDTO;
import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SubscriberRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MailService mailService;

    @PostMapping("/subscriber/send-mail")
    public ResponseEntity<Object> sendMail(@RequestBody MailDTO content) {
        mailService.sendMail(content.getTo(), content.getSubject(), content.getBody());
        logger.info("Send mail successfully");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", null);
    }
}

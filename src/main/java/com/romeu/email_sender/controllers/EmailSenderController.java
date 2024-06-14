package com.romeu.email_sender.controllers;

import com.romeu.email_sender.application.EmailSenderService;
import com.romeu.email_sender.core.dtos.EmailRequestDTO;
import com.romeu.email_sender.core.exceptions.EmailServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDTO requestDTO){
        try {
            this.emailSenderService.sendEmail(requestDTO.to(), requestDTO.subject(), requestDTO.body());
            return ResponseEntity.ok("Email sent successfully");
        } catch (EmailServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}

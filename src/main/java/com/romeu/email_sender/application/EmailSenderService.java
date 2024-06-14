package com.romeu.email_sender.application;

import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.romeu.email_sender.adapters.EmailSenderGateway;
import com.romeu.email_sender.core.EmailSenderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Override
    public SendEmailResult sendEmail(String to, String subject, String body) {
        return this.emailSenderGateway.sendEmail(to, subject, body);
    }
}

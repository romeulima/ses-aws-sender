package com.romeu.email_sender.adapters;

import com.amazonaws.services.simpleemail.model.SendEmailResult;

public interface EmailSenderGateway {

    SendEmailResult sendEmail(String to, String subject, String body);
}

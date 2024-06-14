package com.romeu.email_sender.core;

import com.amazonaws.services.simpleemail.model.SendEmailResult;

public interface EmailSenderUseCase {

    SendEmailResult sendEmail(String to, String subject, String body);
}

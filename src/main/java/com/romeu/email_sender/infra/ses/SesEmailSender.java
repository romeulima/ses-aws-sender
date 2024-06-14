package com.romeu.email_sender.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.romeu.email_sender.adapters.EmailSenderGateway;
import com.romeu.email_sender.core.exceptions.EmailServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Override
    public SendEmailResult sendEmail(String to, String subject, String body) {

        final String FROM = "romeu.sousadp@gmail.com";

        try {
            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(
                            new Destination().withToAddresses(to))
                    .withMessage(new Message()
                            .withBody(new Body()
                                    .withHtml(new Content().withCharset("UTF-8")
                                            .withData(body)))
                            .withSubject(new Content()
                                    .withCharset("UTF-8").withData(subject)))
                    .withSource(FROM);
            return amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException ex) {
            throw new EmailServiceException("Failure while sending email");
        }
    }
}

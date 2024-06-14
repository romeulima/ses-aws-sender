package com.romeu.email_sender.core.dtos;

public record EmailRequestDTO(String to, String subject, String body) {
}

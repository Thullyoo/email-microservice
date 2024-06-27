package com.thullyoo.email_microservice.entities.email;

import java.util.UUID;

public record EmailRequest(UUID userId, String emailTo, String subject, String text) {
}

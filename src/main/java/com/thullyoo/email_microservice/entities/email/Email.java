package com.thullyoo.email_microservice.entities.email;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMAILS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID emailId;

    private String emailTo;
    private String emailFrom;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    private UUID userId;

    private Boolean isSent;

    private LocalDateTime dateCreation;

}

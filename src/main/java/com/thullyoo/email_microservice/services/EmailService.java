package com.thullyoo.email_microservice.services;

import com.thullyoo.email_microservice.entities.email.Email;
import com.thullyoo.email_microservice.entities.email.EmailRequest;
import com.thullyoo.email_microservice.repositories.EmailRepository;
import jakarta.mail.Message;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public Email publishEmail(Email email){
        try{
            email.setEmailFrom(emailFrom);
            email.setDateCreation(LocalDateTime.now());

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            javaMailSender.send(message);

            email.setIsSent(true);
        }catch (MailException e){
            email.setIsSent(false);
        }finally {
            emailRepository.save(email);
        }

        return email;
    }


}

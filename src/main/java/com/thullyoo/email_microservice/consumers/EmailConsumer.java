package com.thullyoo.email_microservice.consumers;

import com.thullyoo.email_microservice.entities.email.Email;
import com.thullyoo.email_microservice.entities.email.EmailRequest;
import com.thullyoo.email_microservice.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${broker.default.email.name}")
    public void consumerMessage(@Payload EmailRequest emailRequest){
        Email email = new Email();
        BeanUtils.copyProperties(emailRequest, email);
        emailService.publishEmail(email);
    }

}

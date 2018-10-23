package com.example.rabbit.microservicio2.event;

import com.example.rabbit.microservicio2.domain.User;
import com.example.rabbit.microservicio2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class receives the events and triggers the associated
 * business logic.
 */
@Slf4j
@Component
class EventHandler {

    private UserService userService;

    @Autowired
    EventHandler(final UserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = "${servicio.queue}")
    void handleMultiplicationSolved(final User event) {
        try {
            userService.addUser(event);
        } catch (final Exception e) {
            // Avoids the event to be re-queued and reprocessed.
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
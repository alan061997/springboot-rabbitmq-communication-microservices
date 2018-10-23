package com.example.rabbit.microservicio1.event;


import com.example.rabbit.microservicio1.domain.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {

    private RabbitTemplate rabbitTemplate;

    // The exchange to use to send anything related to Multiplication
    private String servicioExchange;

    // The routing key to use to send this particular event
    private String servicioSolvedRoutingKey;

    @Autowired
    EventDispatcher(final RabbitTemplate rabbitTemplate,
                    @Value("${servicio.exchange}") final String servicioExchange,
                    @Value("${servicio.solved.key}") final String servicioSolvedRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.servicioExchange = servicioExchange;
        this.servicioSolvedRoutingKey = servicioSolvedRoutingKey;
    }

    public void send(final User userEvent) {
        rabbitTemplate.convertAndSend(
                servicioExchange,
                servicioSolvedRoutingKey,
                userEvent);
    }

}

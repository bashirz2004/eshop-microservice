package com.zamani.config.jms;

import com.zamani.product.ProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsProducer {

    private final JmsTemplate jmsTemplate;

    @Value("${active-mq.topic}")
    private String topic;

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(ProductEvent productEvent) {
        try {
            log.info("Attempting Send message to topic: " + topic);
            jmsTemplate.convertAndSend(topic, productEvent);
            log.info("Sent message to topic: " + topic);
        } catch (Exception e) {
            log.error("Received Exception during send Message to topic: ", e);
        }
    }
}
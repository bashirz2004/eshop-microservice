package com.zamani.config.jms;

import com.zamani.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsProducer {

    private final JmsTemplate jmsTemplate;

    @Value("${active-mq.queue}")
    private String queue;

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(MyEvent message) {
        try {
            log.info("Attempting Send message to : " + queue);
            jmsTemplate.convertAndSend(queue, message);
            log.info("Sent message to : " + queue);
        } catch (Exception e) {
            log.error("Received Exception during send Message: ", e);
        }
    }
}
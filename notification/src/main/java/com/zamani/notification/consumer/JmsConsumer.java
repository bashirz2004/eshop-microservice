package com.zamani.notification.consumer;

import com.zamani.MyEvent;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {
    @Override
    @JmsListener(destination = "${active-mq.queue}", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            MyEvent myEvent = (MyEvent) objectMessage.getObject();
            //do additional processing
            log.info("Received Message: " + myEvent.toString());
        } catch (Exception e) {
            log.error("Received Exception : " + e);
        }

    }
}

package com.zamani.notification.jms;

import com.zamani.product.ProductEvent;
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
    @JmsListener(destination = "${active-mq.topic}", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            ProductEvent productEvent = (ProductEvent) objectMessage.getObject();
            //do additional processing
            log.info("پیام وقوع رویداد دریافت شد: " + productEvent.toString());
        } catch (Exception e) {
            log.error("Received Exception : " + e);
        }

    }
}

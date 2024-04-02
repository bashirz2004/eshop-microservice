package com.zamani.config.jms;

import com.zamani.product.ProductEvent;
import com.zamani.productquery.Product;
import com.zamani.productquery.ProductQueryRepository;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class JmsConsumer implements MessageListener {
    private final ProductQueryRepository productQueryRepository;

    @Override
    @JmsListener(destination = "${active-mq.topic}", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            ProductEvent productEvent = (ProductEvent) objectMessage.getObject();
            //do additional processing
            log.info("پیام وقوع رویداد دریافت شد: " + productEvent.toString());
            Product product = new Product();
            BeanUtils.copyProperties(productEvent.getProductDto(),product);
            productQueryRepository.save(product);
        } catch (Exception e) {
            log.error("Received Exception : " + e);
        }

    }
}

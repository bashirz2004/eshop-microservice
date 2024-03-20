package com.zamani.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
public class ProductCommandCommandService implements IProductCommandService {
    private final IProductCommandRepository iProductCommandRepository;
    private final JmsTemplate jmsTemplate;

    @Value("${active-mq.topic}")
    private String topic;

    public ProductCommandCommandService(IProductCommandRepository iProductCommandRepository, JmsTemplate jmsTemplate) {
        this.iProductCommandRepository = iProductCommandRepository;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        iProductCommandRepository.save(product);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        jmsTemplate.convertAndSend(topic, new ProductEvent("product-created", productDto));
        log.info("رویداد ارسال شد");
        return product;
    }

   /* @Override
    public List<Product> findAll() {
        return iProductCommandRepository.findAll();
    }*/
}

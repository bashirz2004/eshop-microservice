package com.zamani.product;

import com.zamani.MyEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
    private final IProductRepository iProductRepository;
    private final JmsTemplate jmsTemplate;

    @Value("${active-mq.queue}")
    private String queue;

    public ProductService(IProductRepository iProductRepository, JmsTemplate jmsTemplate) {
        this.iProductRepository = iProductRepository;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Product save(Product product) {
        iProductRepository.save(product);
        jmsTemplate.convertAndSend(queue, new MyEvent(UUID.randomUUID().toString(), product.getId().toString(), "product_saved"));
        return product;
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }
}

package com.zamani.delivery.service.order;

import com.zamani.delivery.entity.order.Order;
import com.zamani.delivery.repository.order.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final IOrderRepository iOrderRepository;
    private final IOrderParcelService iOrderParcelService;

    public OrderService(IOrderRepository iOrderRepository, IOrderParcelService iOrderParcelService) {
        this.iOrderRepository = iOrderRepository;
        this.iOrderParcelService = iOrderParcelService;
    }

    @Override
    public List<Order> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public Order save(Order order) {
        return iOrderRepository.save(order);
    }


}

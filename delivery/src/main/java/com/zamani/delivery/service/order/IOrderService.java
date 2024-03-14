package com.zamani.delivery.service.order;


import com.zamani.delivery.entity.order.Order;

import java.util.List;

public interface IOrderService {
    Order save(Order order);

    List<Order> findAll();
}

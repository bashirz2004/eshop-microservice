package com.zamani.delivery.repository.order;

import com.zamani.delivery.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IOrderRepository extends JpaRepository<Order, UUID> {
}

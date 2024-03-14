package com.zamani.delivery.repository.order;

import com.zamani.delivery.entity.order.OrderParcel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IOrderParcelRepository extends JpaRepository<OrderParcel, UUID> {
}

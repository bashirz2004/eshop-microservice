package com.zamani.delivery.service.order;

import com.zamani.delivery.entity.order.OrderParcel;

import java.util.List;

public interface IOrderParcelService {
    OrderParcel save(OrderParcel orderParcel);

    List<OrderParcel> saveAll(List<OrderParcel> orderParcels);
}

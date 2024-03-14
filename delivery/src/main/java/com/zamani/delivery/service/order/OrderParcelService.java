package com.zamani.delivery.service.order;

import com.zamani.delivery.entity.order.OrderParcel;
import com.zamani.delivery.repository.order.IOrderParcelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderParcelService implements IOrderParcelService {
    private final IOrderParcelRepository iOrderParcelRepository;

    public OrderParcelService(IOrderParcelRepository iOrderParcelRepository) {
        this.iOrderParcelRepository = iOrderParcelRepository;
    }

    @Override
    public OrderParcel save(OrderParcel orderParcel) {
        return iOrderParcelRepository.save(orderParcel);
    }

    @Override
    public List<OrderParcel> saveAll(List<OrderParcel> orderParcels) {
        return iOrderParcelRepository.saveAll(orderParcels);
    }
}

package com.zamani.delivery.controller.order;

import com.zamani.delivery.configs.exception.BaseController;
import com.zamani.delivery.entity.order.Order;
import com.zamani.delivery.service.order.IOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController extends BaseController {
    private final IOrderService iOrderService;

    public OrderController(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @PostMapping("/save")
    public Order save(@RequestBody Order order) {
        return iOrderService.save(order);
    }

    @GetMapping("/list")
    public List<Order> findAll() {
        return iOrderService.findAll();
    }

}

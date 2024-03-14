package com.zamani.delivery.controller.customer;

import com.zamani.delivery.configs.exception.BaseController;
import com.zamani.delivery.entity.customer.Customer;
import com.zamani.delivery.service.customer.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController extends BaseController {
    private final ICustomerService iCustomerService;

    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return iCustomerService.save(customer);
    }

    @GetMapping("/list")
    public List<Customer> findAll() {
        return iCustomerService.findAll();
    }
}

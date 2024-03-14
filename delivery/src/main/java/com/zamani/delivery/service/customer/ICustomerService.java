package com.zamani.delivery.service.customer;

import com.zamani.delivery.entity.customer.Customer;

import java.util.List;

public interface ICustomerService {
    Customer save(Customer customer);

    List<Customer> findAll();
}

package com.zamani.delivery.service.customer;

import com.zamani.delivery.entity.customer.Customer;
import com.zamani.delivery.repository.customer.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository iCustomerRepository;

    public CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}

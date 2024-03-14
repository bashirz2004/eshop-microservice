package com.zamani.delivery.repository.customer;

import com.zamani.delivery.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}

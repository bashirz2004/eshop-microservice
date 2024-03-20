package com.zamani.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCommandRepository extends JpaRepository<Product, String> {
}

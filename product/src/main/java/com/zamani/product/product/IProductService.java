package com.zamani.product.product;

import java.util.List;

public interface IProductService {
    Product save(Product product);

    List<Product> findAll();
}

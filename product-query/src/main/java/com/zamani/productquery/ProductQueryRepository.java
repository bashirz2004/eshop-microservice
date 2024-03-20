package com.zamani.productquery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductQueryRepository extends CrudRepository<Product, String> {

}

package com.zamani.productquery;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-query/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ProductQueryController {
    private final ProductQueryRepository productQueryRepository;

    @GetMapping("/findAll")
    @CircuitBreaker(name = "findAll-cb", fallbackMethod = "temporaryProductList")
    public List<Product> findAll(@RequestHeader(value = "correlation-id", required = false) String correlationId) {
        log.info("correlation-id added to request in api gateway : {}", correlationId);
        return (List<Product>) productQueryRepository.findAll();
    }

    public List<Product> temporaryProductList(Throwable throwable) {
        log.error(throwable.getMessage());
        return List.of(new Product(UUID.randomUUID(), "1", "محصول پیش فرض", 100));
    }


}

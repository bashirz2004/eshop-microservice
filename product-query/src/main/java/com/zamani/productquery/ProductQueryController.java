package com.zamani.productquery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-query/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ProductQueryController {
    private final ProductQueryRepository productQueryRepository;

    @GetMapping("/findAll")
    public List<Product> findAll(@RequestHeader(value = "correlation-id", required = false) String correlationId) {
        log.info("correlation-id added to request in api gateway : {}", correlationId);
        return (List<Product>) productQueryRepository.findAll();
    }


}

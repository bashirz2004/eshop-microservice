package com.zamani.product;

import com.zamani.config.exception.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/api/v1")
@Slf4j
public class ProductController extends BaseController {
    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('product-admin')")
    public Product add(@RequestBody Product product) {
        return iProductService.save(product);
    }

    @GetMapping(value = "/findAll")
    public List<Product> findAll(@RequestHeader(value = "correlation-id", required = false) String correlationId) {
        log.info("correlation-id added to request in gateway : {}", correlationId);
        return iProductService.findAll();
    }
}
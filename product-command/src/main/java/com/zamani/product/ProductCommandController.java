package com.zamani.product;

import com.zamani.config.exception.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/api/v1")
@Slf4j
public class ProductCommandController extends BaseController {
    private final IProductCommandService iProductCommandService;

    public ProductCommandController(IProductCommandService iProductCommandService) {
        this.iProductCommandService = iProductCommandService;
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('product-admin')")
    public Product add(@RequestBody Product product) {
        return iProductCommandService.save(product);
    }

   /* @GetMapping(value = "/findAll")
    public List<ProductEvent> findAll(@RequestHeader(value = "correlation-id", required = false) String correlationId) {
        log.info("correlation-id added to request in gateway : {}", correlationId);
        return iProductCommandService.findAll();
    }*/
}

package com.zamani.product;

import com.zamani.config.exception.BaseController;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-command/api/v1")
@Slf4j
public class ProductCommandController extends BaseController {
    private final IProductCommandService iProductCommandService;

    public ProductCommandController(IProductCommandService iProductCommandService) {
        this.iProductCommandService = iProductCommandService;
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('product-admin')")
    public Product add(@RequestBody Product product, @RequestHeader(name = "authorization") @Parameter(hidden = true, name = "authorization") String authorization) {
        return iProductCommandService.save(product);
    }

}

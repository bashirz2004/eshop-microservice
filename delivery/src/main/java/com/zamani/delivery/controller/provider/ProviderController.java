package com.zamani.delivery.controller.provider;

import com.zamani.delivery.configs.exception.BaseController;
import com.zamani.delivery.entity.GenericResponse;
import com.zamani.delivery.entity.provider.Provider;
import com.zamani.delivery.service.provider.IProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/provider")
public class ProviderController extends BaseController {
    private final IProviderService iProviderService;

    public ProviderController(IProviderService iProviderService) {
        this.iProviderService = iProviderService;
    }

    @GetMapping("/list")
    public GenericResponse<Provider> findAll(int offset, int size) {
        return iProviderService.findAll(offset, size);
    }

    @PostMapping("/save")
    public GenericResponse<Provider> save(@RequestBody Provider provider) {
        return iProviderService.save(provider);
    }

    @DeleteMapping("/delete/{id}")
    public GenericResponse<String> deleteById(@PathVariable UUID id) {
        return iProviderService.deleteById(id);
    }
}

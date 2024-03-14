package com.zamani.delivery.controller.parcelsize;

import com.zamani.delivery.configs.exception.BaseController;
import com.zamani.delivery.entity.parcelsize.ParcelSize;
import com.zamani.delivery.service.parcelsize.IParcelSizeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parcelsize")
public class ParcelSizeController extends BaseController {
    private final IParcelSizeService iParcelSizeService;

    public ParcelSizeController(IParcelSizeService iParcelSizeService) {
        this.iParcelSizeService = iParcelSizeService;
    }

    @PostMapping("/save")
    public ParcelSize save(@RequestBody ParcelSize parcelSize) {
        return iParcelSizeService.save(parcelSize);
    }

    @GetMapping("/list")
    public List<ParcelSize> findAll() {
        return iParcelSizeService.findAll();
    }
}

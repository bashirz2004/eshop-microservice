package com.zamani.delivery.service.parcelsize;

import com.zamani.delivery.entity.parcelsize.ParcelSize;

import java.util.List;

public interface IParcelSizeService {
    ParcelSize save(ParcelSize parcelSize);

    List<ParcelSize> findAll();
}

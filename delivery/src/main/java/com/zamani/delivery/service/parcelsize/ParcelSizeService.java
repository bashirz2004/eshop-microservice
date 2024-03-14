package com.zamani.delivery.service.parcelsize;

import com.zamani.delivery.entity.parcelsize.ParcelSize;
import com.zamani.delivery.repository.parcelsize.IParcelSizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelSizeService implements IParcelSizeService {
    private final IParcelSizeRepository iParcelSizeRepository;

    public ParcelSizeService(IParcelSizeRepository iParcelSizeRepository) {
        this.iParcelSizeRepository = iParcelSizeRepository;
    }

    @Override
    public ParcelSize save(ParcelSize parcelSize) {
        return iParcelSizeRepository.save(parcelSize);
    }

    @Override
    public List<ParcelSize> findAll() {
        return iParcelSizeRepository.findAll();
    }
}

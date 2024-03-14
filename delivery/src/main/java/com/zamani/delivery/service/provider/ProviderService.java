package com.zamani.delivery.service.provider;

import com.zamani.delivery.entity.GenericResponse;
import com.zamani.delivery.entity.provider.Provider;
import com.zamani.delivery.repository.provider.jpa.IProviderJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProviderService implements IProviderService {
    private final IProviderJpaRepository iProviderJpaRepository;

    public ProviderService(IProviderJpaRepository iProviderJpaRepository) {
        this.iProviderJpaRepository = iProviderJpaRepository;
    }

    @Override
    public GenericResponse<Provider> save(Provider provider) {
        if (provider.getId() != null) {
            Provider oldProvider = iProviderJpaRepository.findById(provider.getId()).get();
            if (!oldProvider.getAddress().equals(provider.getAddress()))
                throw new RuntimeException("آدرس قابل تغییر نمی باشد.");
        }
        return GenericResponse.<Provider>builder()
                .singleResult(iProviderJpaRepository.save(provider))
                .build();
    }

    @Override
    public GenericResponse<String> deleteById(UUID id) {
        iProviderJpaRepository.deleteById(id);
        return GenericResponse.<String>builder()
                .singleResult("حذف با موفقیت انجام شد.")
                .build();
    }


    @Override
    public GenericResponse<Provider> findAll(int offset, int size) {
        Pageable pageable = PageRequest.of((offset / size), size, Sort.Direction.DESC, "createDate");
        Page<Provider> providersPage = iProviderJpaRepository.findAll(pageable);
        return GenericResponse.<Provider>builder()
                .result(providersPage.getContent())
                .totalCount(providersPage.getTotalElements())
                .offset(pageable.getOffset())
                .size(pageable.getPageSize())
                .build();
    }
}

package com.zamani.delivery.service.provider;

import com.zamani.delivery.entity.GenericResponse;
import com.zamani.delivery.entity.provider.Provider;

import java.util.UUID;

public interface IProviderService {
    GenericResponse<Provider> save(Provider provider);

    GenericResponse<String> deleteById(UUID id);

    GenericResponse<Provider> findAll(int offset, int size);
}

package com.zamani.delivery.repository.provider.jpa;

import com.zamani.delivery.entity.provider.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProviderJpaRepository extends JpaRepository<Provider, UUID> {
}

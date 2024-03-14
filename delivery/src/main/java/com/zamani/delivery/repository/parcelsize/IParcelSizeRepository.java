package com.zamani.delivery.repository.parcelsize;

import com.zamani.delivery.entity.parcelsize.ParcelSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParcelSizeRepository extends JpaRepository<ParcelSize, String> {
}

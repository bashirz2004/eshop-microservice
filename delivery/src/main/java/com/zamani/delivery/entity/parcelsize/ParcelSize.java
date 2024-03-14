package com.zamani.delivery.entity.parcelsize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zamani.delivery.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParcelSize extends BaseEntity {
    @Column(name = "name", length = 50, nullable = false)
    private String name; //بسته سایز 1

    @Column(name = "length", nullable = false)
    private int length;

    @Column(name = "width", nullable = false)
    private int width;

    @Column(name = "height", nullable = false)
    private int height;


}

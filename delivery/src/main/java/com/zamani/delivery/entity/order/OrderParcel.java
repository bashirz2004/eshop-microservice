package com.zamani.delivery.entity.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zamani.delivery.entity.BaseEntity;
import com.zamani.delivery.entity.parcelsize.ParcelSize;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "del_order_parcel")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderParcel extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcel_size_id", nullable = false)
    private ParcelSize parcelSize;

    @Column(name = "weight_in_gram", nullable = false)
    private long weightInGram; //وزن به گرم

    @Column(name = "value_in_rial", nullable = false)
    private long valueInRial; //بهای محتویات بسته به ریال

}


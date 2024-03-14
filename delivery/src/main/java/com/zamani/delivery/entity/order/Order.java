package com.zamani.delivery.entity.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zamani.delivery.entity.BaseEntity;
import com.zamani.delivery.entity.customer.Customer;
import com.zamani.delivery.entity.provider.Provider;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "del_order")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private Customer sender; //فرستنده

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", nullable = false)
    private Customer receiver; //گیرنده

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;  //حمل کننده

    @Column(name = "price", nullable = false)
    private long price; //هزینه حمل

    @Column(name = "pickup_date", nullable = false)
    private String pickupDate; // تاریخ شمسی جمع آوری توسط حمل کننده

    @Column(name = "pickup_hour_from", nullable = false)
    private int pickupHourFrom; // از ساعت جمع آوری توسط حمل کننده

    @Column(name = "pickup_hour_to", nullable = false)
    private int pickupHourTo; // تا ساعت جمع آوری توسط حمل کننده

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private List<OrderParcel> orderParcels = new ArrayList<>();

}

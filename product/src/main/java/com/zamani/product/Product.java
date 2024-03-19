package com.zamani.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prd_product")
public class Product {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private long price;

}

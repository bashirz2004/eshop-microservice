package com.zamani.product;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto implements Serializable {
    private UUID id;
    private String code;
    private String name;
    private long price;
}

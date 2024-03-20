package com.zamani.product;

import lombok.*;

import java.io.Serializable;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEvent implements Serializable {
    private String eventName;
    private ProductDto productDto;
}

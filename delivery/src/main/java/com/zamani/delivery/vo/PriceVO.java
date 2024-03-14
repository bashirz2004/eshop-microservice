package com.zamani.delivery.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class PriceVO extends BaseValueObject {
    private long amount;
    private String type;

    public static PriceVO rial(long amount) {
        return PriceVO.builder()
                .amount(amount)
                .type("RIAL")
                .build();
    }

    public static PriceVO toman(long amount) {
        return PriceVO.builder()
                .amount(amount)
                .type("TOMAN")
                .build();
    }

    @Override
    protected List<Object> getAtomicValues() {
        List x = new ArrayList<>();
        x.add(amount);
        x.add(type);
        return x;
    }


}

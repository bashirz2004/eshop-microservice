package com.zamani.delivery.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class AddressVO extends BaseValueObject {
    private String state;
    private String city;
    private String street1;
    private String street2;
    private String plaque;
    private Integer floor;
    private Integer unit;
    private String postalCode;

    @JsonCreator
    public AddressVO(@JsonProperty("state") String state,
                     @JsonProperty("city") String city,
                     @JsonProperty("street1") String street1,
                     @JsonProperty("street2") String street2,
                     @JsonProperty("plaque") String plaque,
                     @JsonProperty("floor") Integer floor,
                     @JsonProperty("unit") Integer unit,
                     @JsonProperty("postalCode") String postalCode) {
        this.state = state;
        this.city = city;
        this.street1 = street1;
        this.street2 = street2;
        this.plaque = plaque;
        this.floor = floor;
        this.unit = unit;
        if (postalCode.length() != 10)
            throw new IllegalArgumentException("کد پستی باید 10 رقمی باشد.");
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "استان " + this.state + " ," + "شهر " + this.city + " ," + this.street1 + " " + this.street2 +
                " پلاک " + this.plaque + " طبقه " + this.floor + " واحد " + this.unit + " کدپستی " + this.postalCode;
    }

    @Override
    protected List getAtomicValues() {
        return Arrays.asList(this.state,
                this.city,
                this.street1,
                this.street2,
                this.plaque,
                this.floor,
                this.unit);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, city, street1, street2, plaque, floor, unit, postalCode);
    }
}

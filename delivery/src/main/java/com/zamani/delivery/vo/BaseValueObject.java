package com.zamani.delivery.vo;

import jakarta.persistence.MappedSuperclass;

import java.util.List;

@MappedSuperclass
public abstract class BaseValueObject {

    protected abstract List getAtomicValues();

    @Override
    public boolean equals(Object obj) {
        BaseValueObject left = (BaseValueObject) obj;
        List atomicValues = left.getAtomicValues();
        for (int i = 0; i < atomicValues.size(); i++) {
            if (!atomicValues.get(i).equals(this.getAtomicValues().get(i)))
                return false;
        }
        return true;
    }


}

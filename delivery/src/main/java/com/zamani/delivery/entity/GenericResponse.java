package com.zamani.delivery.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class GenericResponse<T> {
    private boolean hasError;
    private long offset;
    private long size;
    private long totalCount;
    private List<T> result;
    private T singleResult;
}

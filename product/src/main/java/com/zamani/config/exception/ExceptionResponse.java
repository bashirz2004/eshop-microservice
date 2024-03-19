package com.zamani.config.exception;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    public String message;
    public int code;
}

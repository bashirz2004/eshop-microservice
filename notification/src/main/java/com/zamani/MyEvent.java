package com.zamani;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyEvent implements Serializable {
    private String uuid;
    private String entityId;
    private String eventName;
}

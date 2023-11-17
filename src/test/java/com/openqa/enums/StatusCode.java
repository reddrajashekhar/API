package com.openqa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    STATUS_OK(200),
    STATUS_CREATED(201);

    private int statusCode;
}

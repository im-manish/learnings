/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 17/05/21, 3:55 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import lombok.Getter;
import lombok.Setter;

public class CustomException extends Throwable {
    @Setter
    @Getter
    private String message;

    public CustomException(Throwable e) {
        this.message = e.getMessage();
    }
}

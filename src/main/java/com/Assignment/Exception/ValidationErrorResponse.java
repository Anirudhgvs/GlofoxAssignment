package com.Assignment.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorResponse {

    private String field;
    private Object rejectedValue;
    private String message;

}

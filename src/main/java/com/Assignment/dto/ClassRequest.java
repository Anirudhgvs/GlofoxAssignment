package com.Assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassRequest {

    private String className;
    private String startDate;
    private String endDate;
    private Integer capacity;

}

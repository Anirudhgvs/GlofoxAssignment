package com.Assignment.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassRequest {

    @NotBlank(message = "class name is required")
    private String className;

    @NotBlank(message = "start date is required")
    private String startDate;

    @NotBlank(message = "end date is required")
    private String endDate;

    @NotNull(message = "capacity must not be null")
    private Integer capacity;

}

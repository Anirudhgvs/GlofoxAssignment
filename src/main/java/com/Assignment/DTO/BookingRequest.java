package com.Assignment.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    @NotBlank(message = "Member name is required")
    private String memberName;

    @NotBlank(message = "Class name is required")
    private String className;

    @NotBlank(message = "Date is required")
    private String date;

}

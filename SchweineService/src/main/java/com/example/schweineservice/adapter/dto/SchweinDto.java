package com.example.schweineservice.adapter.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchweinDto {

    @NotNull
    @Size(min = 36, max=36)
    private String id;


    @NotNull
    @Size(min = 2, max=30)
    private String name;

    @DecimalMin("10")
    private int gewicht;


}

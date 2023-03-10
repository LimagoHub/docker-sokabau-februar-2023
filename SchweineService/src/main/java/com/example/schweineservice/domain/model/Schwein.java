package com.example.schweineservice.domain.model;


import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schwein {

    private String id;


    private String name;
    private int gewicht;

    public void fuettern() {
        gewicht ++;
    }
}

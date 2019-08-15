package com.aioria.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class User {

    private Long id;
    private String name;
    private Double salary;
    private Integer age;
}

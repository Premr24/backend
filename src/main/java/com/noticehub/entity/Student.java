package com.noticehub.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
}

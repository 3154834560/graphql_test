package com.example.demo.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 王景阳
 * @date 2023-03-25 17:08
 */
@Data
public class Student {
    private String id;
    private String name;
    private SexEnum sex;
    private LocalDateTime birthday;
    private Classes classes;
}

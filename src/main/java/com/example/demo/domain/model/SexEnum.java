package com.example.demo.domain.model;

import lombok.Getter;

/**
 * @author 王景阳
 * @date 2023-03-25 17:56
 */
@Getter
public enum SexEnum {
    /**
     * 男
     */
    MALE("男"),
    /**
     * 女
     */
    FEMALE("女");

    SexEnum(String sex) {
        this.sex = sex;
    }

    private final String sex;
}

package com.example.demo.application.dto.input;

import com.example.demo.domain.model.SexEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 王景阳
 * @date 2023-03-25 17:08
 */
@Data
public class StudentInput {
    private String name;
    private SexEnum sex;
    private LocalDateTime birthday;
    private ClassesInput classesInput;
}

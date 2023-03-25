package com.example.demo.application.dto.input;

import cn.hutool.core.lang.UUID;
import com.example.demo.domain.model.Classes;
import lombok.Data;

/**
 * @author 王景阳
 * @date 2023-03-25 18:29
 */
@Data
public class ClassesInput {
    private String name;

    public Classes to() {
        Classes classes = new Classes();
        classes.setId(UUID.fastUUID().toString());
        classes.setName(name);
        return classes;
    }
}

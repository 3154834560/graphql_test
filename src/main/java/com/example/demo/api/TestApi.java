package com.example.demo.api;

import com.example.demo.domain.model.SexEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王景阳
 * @date 2023-03-25 17:59
 */
@RestController
@RequestMapping("/test")
public class TestApi {
    @GetMapping
    public SexEnum sexEnum(SexEnum sexEnum){
        System.out.println(sexEnum);
        return sexEnum;
    }
}

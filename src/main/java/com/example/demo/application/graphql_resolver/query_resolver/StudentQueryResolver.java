package com.example.demo.application.graphql_resolver.query_resolver;

import cn.hutool.core.lang.UUID;
import com.example.demo.domain.model.SexEnum;
import com.example.demo.domain.model.Student;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王景阳
 * @date 2023-03-25 18:20
 */
@Component
public class StudentQueryResolver implements GraphQLQueryResolver {

    public Student studentQuery() {
        Student student = new Student();
        student.setId(UUID.fastUUID().toString());
        student.setName("wjy");
        student.setSex(SexEnum.MALE);
        student.setBirthday(LocalDateTime.now());
        return student;
    }


    public List<Student> studentQueryList() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setId(UUID.fastUUID().toString());
            student.setName("wjy  " + i);
            student.setSex(SexEnum.MALE);
            students.add(student);
            student.setBirthday(LocalDateTime.now());
        }
        return students;
    }

    public Student studentQueryBy(String id) {
        Student student = new Student();
        student.setId(id);
        student.setName("wjy");
        student.setSex(SexEnum.MALE);
        student.setBirthday(LocalDateTime.now());
        return student;
    }
}

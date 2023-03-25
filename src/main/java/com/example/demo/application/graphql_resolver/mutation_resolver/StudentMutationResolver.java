package com.example.demo.application.graphql_resolver.mutation_resolver;

import cn.hutool.core.lang.UUID;
import com.example.demo.application.dto.input.StudentInput;
import com.example.demo.domain.model.Student;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

/**
 * @author 王景阳
 * @date 2023-03-25 18:32
 */
@Component
public class StudentMutationResolver implements GraphQLMutationResolver {

    public Student createStudent(StudentInput input) {
        Student student = new Student();
        student.setId(UUID.fastUUID().toString());
        student.setName("软件工程");
        student.setSex(input.getSex());
        student.setBirthday(input.getBirthday());
        student.setClasses(input.getClassesInput().to());
        return student;
    }
}

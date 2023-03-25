package com.example.demo.application.graphql_resolver.mutation_resolver;

import cn.hutool.core.lang.UUID;
import com.example.demo.application.dto.input.ClassesInput;
import com.example.demo.domain.model.Classes;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

/**
 * @author 王景阳
 * @date 2023-03-25 18:20
 */
@Component
public class ClassesMutationResolver implements GraphQLMutationResolver {

    public Classes createClasses(ClassesInput input) {
        Classes classes = new Classes();
        classes.setId(UUID.fastUUID().toString());
        classes.setName("软件工程");
        return classes;
    }
}

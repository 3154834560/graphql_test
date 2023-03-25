package com.example.demo.application.graphql_resolver.query_resolver;

import cn.hutool.core.lang.UUID;
import com.example.demo.domain.model.Classes;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王景阳
 * @date 2023-03-25 18:20
 */
@Component
public class ClassesQueryResolver implements GraphQLQueryResolver {

    public Classes classesQuery() {
        Classes classes = new Classes();
        classes.setId(UUID.fastUUID().toString());
        classes.setName("软件工程");
        return classes;
    }


    public List<Classes> classesQueryList() {
        List<Classes> classesList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Classes classes = new Classes();
            classes.setId(UUID.fastUUID().toString());
            classes.setName("软件工程   " + i);
            classesList.add(classes);
        }
        return classesList;
    }

    public Classes classesQueryBy(String id) {
        Classes classes = new Classes();
        classes.setId(id);
        classes.setName("软件工程");
        return classes;
    }
}

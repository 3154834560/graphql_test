package com.example.demo.application.graphql_resolver.resolver;

import com.example.demo.domain.model.Classes;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

/**
 * GraphQLResolver接口是Java程序中实现GraphQL解析的接口，通常用来为GraphQL schema中定义的类型提供自定义的解析方法。
 * java中GraphQLResolver接口是用于定义GraphQL查询和变异的解析器的，因此在query和mutation时都会被调用。
 * <p>
 * 相当于在向前端响应数据前一刻对Classes类型的数据进行拦截，并通过变量名去寻找相同的方法名，执行与变量名相同的方法
 * 方法的返回类型必须是与之同名的变量，对应的数据类型，方法必须要用参数，且参数只能为Classes类型
 * 方法不能为private类型
 * <p>
 * 可以在此类中对懒加载的数据进行处理
 *
 * @author 王景阳
 * @date 2023-03-26 14:32
 */
@Component
public class ClassesResolver implements GraphQLResolver<Classes> {

    /**
     * 该方法名要与Classes类中id相同，返回类型要与id变量类型相同，且参数类型必须是Classes，方法不能为private类型
     */
    public String id(Classes classes) {
        System.out.println("ClassesResolver--->classes--->id: " + classes.getId());
        return classes.getId();
    }

    /**
     * 该方法名要与Classes类中name相同，返回类型要与name变量类型相同，且参数类型必须是Classes，方法不能为private类型
     */
    public String name(Classes classes) {
        System.out.println("ClassesResolver--->classes--->name: " + classes.getName());
        return classes.getName();
    }
}

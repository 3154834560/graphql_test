package com.example.demo.config.handler;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.kickstart.spring.error.ErrorContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Graphql全局异常拦截
 *
 * @author 王景阳
 * @date 2023-03-26 12:22
 */
@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler(Exception.class)
    public GraphQLError handleNormalException(Exception e, ErrorContext ctx) {
        return GraphqlErrorBuilder.newError()
                .path(ctx.getPath())
                .locations(ctx.getLocations())
                .errorType(ctx.getErrorType())
                .message(e.getMessage())
                .build();
    }
}

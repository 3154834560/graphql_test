package com.example.demo.application.scalars;

import graphql.language.IntValue;
import graphql.language.StringValue;
import graphql.schema.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author 王景阳
 * @date 2023-03-25 20:17
 */
@Configuration
public class LocalDateTimeScalar {

    /**
     * NOTICE: 注意使用 秒级 时间戳
     */
    @Bean
    public GraphQLScalarType graphqlscalartype() {
        String localDateTimeStr = "LocalDateTime";
        String description = "当地日期时间";
        return GraphQLScalarType.newScalar()
                .name(localDateTimeStr)
                .description(description)
                .coercing(new LocalDateTimeCoercing())
                .build();
    }

    private static class LocalDateTimeCoercing implements Coercing<LocalDateTime, Long> {
        /**
         * 当后端向前端发送 LocalDateTime 类型数据时调用的方法，将 LocalDateTime 型的数据转换为 Long 型再传给前端
         */
        @Override
        public Long serialize(@NotNull Object o) throws CoercingSerializeException {
            if (o instanceof LocalDateTime) {
                return ((LocalDateTime) o).toEpochSecond(ZoneOffset.ofHours(8));
            } else {
                throw new CoercingSerializeException("Unable to serialize " + o + " as LocalDateTime");
            }
        }

        /**
         * parseValue用来读取从客户端传递的变量值
         */
        @NotNull
        @Override
        public LocalDateTime parseValue(@NotNull Object o) throws CoercingParseValueException {
            return parse(o);
        }

        /**
         * parseLiteral用来读取从客户端传递的常量值
         */
        @NotNull
        @Override
        public LocalDateTime parseLiteral(@NotNull Object o) throws CoercingParseLiteralException {
            return parse(o);
        }

        private LocalDateTime parse(Object o) {
            long time;
            if (o instanceof Long) {
                time = (Long) o;
            } else if (o instanceof String) {
                time = Long.parseLong((String) o);
            } else if (o instanceof StringValue) {
                time = Long.parseLong(((StringValue) o).getValue());
            } else if (o instanceof IntValue) {
                time = ((IntValue) o).getValue().longValue();
            } else {
                throw new CoercingParseValueException("Unable to parse value " + o + " as LocalDateTime");
            }
            return LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.ofHours(8));
        }
    }

}

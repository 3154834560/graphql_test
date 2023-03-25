package com.example.demo.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义LocalDateTime转换器,目前仅提供 (Long/String->LocalDateTime)
 * 仅适用于PathVariable和RequestParam
 *
 * @author 王景阳
 * @date 2023-03-25 18:20
 */
public class LocalDateTimeConverter implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(Long.class, LocalDateTime.class));
        convertiblePairs.add(new ConvertiblePair(String.class, LocalDateTime.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, @NotNull TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (targetType.hasAnnotation(PathVariable.class) && source == null) {
            throw new IllegalArgumentException("PathVariable variable can not be null!");
        }
        String str = source.toString();
        try {
            return LocalDateTime.ofEpochSecond(Long.parseLong(str), 0, ZoneOffset.ofHours(8));
        } catch (NumberFormatException e) {
            return LocalDateTime.parse(str, DateTimeFormatter.ISO_DATE_TIME);
        }
    }
}

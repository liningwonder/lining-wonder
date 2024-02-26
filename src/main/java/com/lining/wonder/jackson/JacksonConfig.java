package com.lining.wonder.jackson;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liningwonder
 */
@Configuration
public class JacksonConfig {

    /**
     * 该配置用于jackson序列化时，将Long类型转为String类型，避免前端丢失精度
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        Map<Class<?>, JsonSerializer<?>> map = new HashMap<>();
        map.put(Long.class, ToStringSerializer.instance);
        return builder -> builder.serializersByType(map);
    }

}

package com.sophy.api.redis.converter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophy.api.redis.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Component @ReadingConverter
public class ByteToUserConverter implements Converter<byte[],User> {
    private final Jackson2JsonRedisSerializer<User> serializer;

    public ByteToUserConverter() {
        serializer = new Jackson2JsonRedisSerializer<>(User.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public User convert(byte[] source) {
        return serializer.deserialize(source);
    }
}

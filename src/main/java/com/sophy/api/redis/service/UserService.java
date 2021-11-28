package com.sophy.api.redis.service;

import com.sophy.api.redis.converter.ByteToUserConverter;
import com.sophy.api.redis.converter.UserToByteConverter;
import com.sophy.api.redis.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RedisTemplate redisTemplate;
    private final UserToByteConverter userToByteConverter;
    private final ByteToUserConverter byteToUserConverter;

    public void save(User user) {
        HashOperations operations = redisTemplate.opsForHash();      //메모리 주소값(hash)
//        operations.put("user", user.toString(), userToByteConverter.convert(user));
        operations.put("user", user.getId(), userToByteConverter.convert(user));
    }

    public User findUserById(String id) {
        HashOperations operations = redisTemplate.opsForHash();      //메모리 주소값(hash)
        return byteToUserConverter.convert((byte[]) operations.get("user",id ));

    }
}

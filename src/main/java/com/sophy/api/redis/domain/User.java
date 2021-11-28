package com.sophy.api.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return String.format("%s, %s, %s \n", id, name, email);
    }
}
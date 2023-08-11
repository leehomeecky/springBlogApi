package com.meecky.springBlogApi.users.dto;

import java.util.Optional;

public record userResponse(String message, int code, Optional<? super userDto> data) {
    public  userResponse (String message, int code){
        this(message, code, Optional.empty());
    }
}

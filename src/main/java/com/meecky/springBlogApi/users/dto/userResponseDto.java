package com.meecky.springBlogApi.users.dto;

import java.util.Optional;

public record userResponseDto(String message, int code, Optional<? super userDto> data) {
    public userResponseDto(String message, int code){
        this(message, code, Optional.empty());
    }
}

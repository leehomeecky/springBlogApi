package com.meecky.springBlogApi.exception.dto;

import java.time.LocalDateTime;

public record ExceptionDetailsDto(LocalDateTime timeStamp, String message, String description, Integer code) {
}

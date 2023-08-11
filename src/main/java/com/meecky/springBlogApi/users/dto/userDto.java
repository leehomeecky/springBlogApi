package com.meecky.springBlogApi.users.dto;

import java.time.LocalDate;

public record userDto(long id, String name, LocalDate birthDay){};

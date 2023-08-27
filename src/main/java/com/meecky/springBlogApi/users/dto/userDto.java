package com.meecky.springBlogApi.users.dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record userDto(long id,
                      @Size(min = 2, message = "name must have at-least 2 character")
                      String name,
                      @Past(message = "birthDay must be in the past")
                      LocalDate birthDay){};

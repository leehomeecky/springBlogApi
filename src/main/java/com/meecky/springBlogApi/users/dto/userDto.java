package com.meecky.springBlogApi.users.dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record userDto(long id,
                      @Size(min = 2)
                      String name,
                      @Past
                      LocalDate birthDay){};

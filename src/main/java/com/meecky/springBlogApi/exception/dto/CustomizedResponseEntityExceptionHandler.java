package com.meecky.springBlogApi.exception.dto;

import com.meecky.springBlogApi.users.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<? super ExceptionDetailsDto> handleAllException(Exception ex, WebRequest request) throws Exception {
        ExceptionDetailsDto exception = new ExceptionDetailsDto(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), 1);
        return new ResponseEntity<ExceptionDetailsDto>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<? super ExceptionDetailsDto> handleNotFoundException(Exception ex, WebRequest request) throws Exception {
        ExceptionDetailsDto exception = new ExceptionDetailsDto(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), 1);
        return new ResponseEntity<ExceptionDetailsDto>(exception, HttpStatus.NOT_FOUND);
    }
}

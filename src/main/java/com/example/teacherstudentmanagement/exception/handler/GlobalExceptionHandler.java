package com.example.teacherstudentmanagement.exception.handler;

import com.example.teacherstudentmanagement.dto.response.ExceptionDto;
import com.example.teacherstudentmanagement.exception.AlreadyExistException;
import com.example.teacherstudentmanagement.exception.BadRequestException;
import com.example.teacherstudentmanagement.exception.IsNotActiveException;
import com.example.teacherstudentmanagement.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handleNotFound(NotFoundException ex) {
        log.error("ActionLog.error not found: {} ", ex.getMessage());
        return new ExceptionDto(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDto handleAlreadyExists(AlreadyExistException ex) {
        log.error("ActionLog.error AlreadyExists: {} ", ex.getMessage());
        return new ExceptionDto(HttpStatus.CONFLICT.value(), ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleBadRequest(BadRequestException ex) {
        log.error("ActionLog.error BadRequestException: {} ", ex.getMessage());
        return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(IsNotActiveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleIsNotActive(IsNotActiveException ex) {
        log.error("ActionLog.error IsNotActiveException: {} ", ex.getMessage());
        return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}

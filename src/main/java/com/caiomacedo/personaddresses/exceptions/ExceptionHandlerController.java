package com.caiomacedo.personaddresses.exceptions;

import com.caiomacedo.personaddresses.exceptions.person.PersonAlreadyExistsException;
import com.caiomacedo.personaddresses.exceptions.person.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = PersonAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage personAlreadyExists() {
        return new ErrorMessage("The given person already exists");
    }

    @ExceptionHandler(value = PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage personNotFoundException() {
        return new ErrorMessage("The given person was not found");
    }
}

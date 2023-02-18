package com.softWalter.solicitation.presentations.execptions;

import com.softWalter.solicitation.domain.usecases.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(
            NotFoundException notFoundException) {

        ApiError apiError = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                notFoundException.getMessage(),
                new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}

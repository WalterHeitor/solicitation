package com.softWalter.solicitation.presentations.execptions;

import com.softWalter.solicitation.domain.usecases.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(
            NotFoundException notFoundException) {

        ApiError apiError = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                notFoundException.getMessage(),
                new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleBadCredentialsException(
            BadCredentialsException badCredentialsException) {

        ApiError apiError = new ApiError(
                HttpStatus.UNAUTHORIZED.value(),
                badCredentialsException.getMessage(),
                new Date());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDeniedException(
            AccessDeniedException accessDeniedException) {

        ApiError apiError = new ApiError(
                HttpStatus.FORBIDDEN.value(),
                accessDeniedException.getMessage(),
                new Date());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        String defautMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        ApiError apiError = new ApiError(HttpStatus.BAD_GATEWAY.value(), defautMessage, new Date());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}

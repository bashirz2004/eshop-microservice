package com.zamani.delivery.configs.exception;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@Slf4j
@RestController
public class BaseController {
    public static final String MESSAGE = "exception object is null!";

    @ExceptionHandler(ValueInstantiationException.class)
    public ExceptionResponse handleUncaughtException(HttpServletResponse response, ValueInstantiationException ex) {
        String handledMessage = ex != null ? ex.getCause().getMessage() : MESSAGE;
        response.setStatus(400);
        return ExceptionResponse.builder().message(handledMessage).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ExceptionResponse handleUncaughtException(HttpServletResponse response, IllegalArgumentException ex) {
        String handledMessage = ex != null ? ex.getCause().getMessage() : MESSAGE;
        response.setStatus(400);
        return ExceptionResponse.builder().message(handledMessage).build();
    }

    @ExceptionHandler(SQLException.class)
    public ExceptionResponse handleUncaughtException(HttpServletResponse response, SQLException ex) {
        String handledMessage = ex != null ? ex.getMessage() : MESSAGE;
        response.setStatus(400);
        return ExceptionResponse.builder().message(handledMessage).build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ExceptionResponse handleUncaughtException(HttpServletResponse response, RuntimeException ex) {
        String handledMessage = ex != null ? ex.getMessage() : MESSAGE;
        response.setStatus(400);
        return ExceptionResponse.builder().message(handledMessage).build();
    }
}

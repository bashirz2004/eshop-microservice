package com.zamani.product.configs.exception;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class BaseController {
    public static final String MESSAGE = "exception object is null!";

    @ExceptionHandler(RuntimeException.class)
    public ExceptionResponse handleUncaughtException(HttpServletResponse response, Exception ex) {
        String handledMessage = ex != null ? ex.getMessage() : MESSAGE;
        if (ex != null && ex.getMessage() != null && ex.getMessage().toLowerCase().contains("required"))
            response.setStatus(400);
        else
            response.setStatus(500);

        handledMessage += ex != null && ex.getStackTrace() != null && ex.getStackTrace().length > 0 && ex.getStackTrace()[0] != null ? " " + ex.getStackTrace()[0] : "";
        handledMessage = handledMessage.replaceAll("\"", "");
        return ExceptionResponse.builder().code(response.getStatus()).message(handledMessage).build();
    }
}

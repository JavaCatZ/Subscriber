package com.test.projects.subscriber.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.charset.StandardCharsets;

@ControllerAdvice
public class RestExceptionHandler {

    /**
     * Перехватывает rest ошибку
     *
     * @param ex экземпляр ошибки класса RestException
     * @return сформированное сообщение об ошибке для ответа
     */
    @ExceptionHandler(RestException.class)
    public ResponseEntity<ErrorMessage> handleRestException(RestException ex) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name());

        return new ResponseEntity<>(ErrorMessage.builder()
                .status(ex.getErrorType().getStatus().value())
                .error(ex.getErrorType().getTitle())
                .message(ex.getMessage())
                .build(), headers, ex.getErrorType().getStatus());
    }
}
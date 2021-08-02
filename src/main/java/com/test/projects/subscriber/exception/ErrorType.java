package com.test.projects.subscriber.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Типы кастомных ошибок приложения
 */
@AllArgsConstructor
@Getter
public enum ErrorType {

    INVALID_MESSAGE_TYPE(HttpStatus.BAD_REQUEST, "Invalid message type"),
    JSON_CONVERT_ERROR(HttpStatus.BAD_REQUEST, "Json convert error"),
    UNEXPECTED_ERROR(HttpStatus.BAD_REQUEST, "Unexpected error");

    private final HttpStatus status;
    private final String title;
}

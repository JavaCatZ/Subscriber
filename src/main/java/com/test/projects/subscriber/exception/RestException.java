package com.test.projects.subscriber.exception;

import lombok.Getter;

/**
 * REST ошибка приложения
 */
@Getter
public class RestException extends RuntimeException {

    /* Тип ошибки */
    private final ErrorType errorType;

    /* Сообщение из сгенерированной ошибки */
    private final String message;

    public RestException(ErrorType errorType, String message) {
        super();
        this.errorType = errorType;
        this.message = message;
    }
}

package com.test.projects.subscriber.exception;

import lombok.Builder;
import lombok.Data;

/**
 * Сообщение об ошибке, отправляемое в ответе сервису
 */
@Builder
@Data
public class ErrorMessage {

    /* Статус ответа в виде числа */
    private Integer status;

    /* Ошибка */
    private String error;

    /* Сообщение из сгенерированной ошибки */
    private String message;
}
package com.test.projects.subscriber.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exc {

    /**
     * Генерирует ошибку, указанного типа
     *
     * @param errorType тип ошибки из enum ErrorType
     * @param message подробное описание ошибки
     * @return сгенерированная ошибка
     */
    public static RestException generate(ErrorType errorType, String message) {
        log.error(String.format("Сгенерирована ошибка с типом: %s и сообщением: %s", errorType.name(), message));
        return new RestException(errorType, message);
    }
}

package com.test.projects.subscriber.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class MessageDTO {

    /* Идентификатор сообщения */
    @NotNull
    Long id;

    /* Уникальный номер абонента */
    @NotNull
    Long msisdn;

    /* Тип сообщения */
    @NotNull
    @NotBlank
    String action;

    /* UNIX timestamp */
    @NotNull
    Timestamp timestamp;
}
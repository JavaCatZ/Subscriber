package com.test.projects.subscriber.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(schema = "messages", name = "purchase_message")
@Data
public class PurchaseMessage {

    /* Идентификатор сообщения */
    @Id
    @NotNull
    @Column(name = "id", unique = true, nullable = false)
    Long id;

    /* Уникальный номер абонента */
    @Column(name = "msisdn")
    @NotNull
    Long msisdn;

    /* Тип сообщения */
    @NotNull
    @NotBlank
    @Column(name = "action")
    String action;

    /* UNIX timestamp */
    @NotNull
    @Column(name = "timestamp")
    Timestamp timestamp;
}
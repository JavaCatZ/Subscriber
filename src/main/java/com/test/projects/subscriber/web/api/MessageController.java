package com.test.projects.subscriber.web.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.test.projects.subscriber.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/messages")
@Validated
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    /**
     * Сохраняет полученное сообщение
     *
     * @param jsonMessage JSON-объект полученного сообщения
     * @return идентификатор сохранённой сущности сообщения
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveMessage(@Valid @NotNull @RequestBody JsonNode jsonMessage) {
        return messageService.saveMessage(jsonMessage);
    }
}
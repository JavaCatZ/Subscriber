package com.test.projects.subscriber.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.projects.subscriber.constants.MessageType;
import com.test.projects.subscriber.domain.dto.MessageDTO;
import com.test.projects.subscriber.exception.ErrorType;
import com.test.projects.subscriber.exception.Exc;
import com.test.projects.subscriber.mapper.MessageMapper;
import com.test.projects.subscriber.repository.PurchaseMessageRepository;
import com.test.projects.subscriber.repository.SubscriptionMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final PurchaseMessageRepository purchaseMessageRepository;
    private final SubscriptionMessageRepository subscriptionMessageRepository;
    private final MessageMapper messageMapper;

    /**
     * Сохраняет полученное сообщение
     *
     * @param jsonMessage JSON-объект полученного сообщения
     * @return идентификатор сохранённой сущности сообщения
     */
    @Transactional
    public Long saveMessage(JsonNode jsonMessage) {
        ObjectMapper objectMapper = new ObjectMapper();
        MessageDTO messageDTO;

        try {
            messageDTO = objectMapper.treeToValue(jsonMessage, MessageDTO.class);

            log.info(String.format("Сохранение сообщения с id: %d и типом: %s", messageDTO.getId(),
                    messageDTO.getAction()));
            switch (MessageType.valueOf(messageDTO.getAction())) {
                case PURCHASE:
                    return purchaseMessageRepository.save(messageMapper
                            .toPurchaseMessageEntity(messageDTO)).getId();
                case SUBSCRIPTION:
                    return subscriptionMessageRepository.save(messageMapper
                            .toSubscriptionMessageEntity(messageDTO)).getId();
                default:
                    log.error("Ошибка неверного типа сообщения");
                    throw Exc.generate(ErrorType.INVALID_MESSAGE_TYPE,
                            "Переданный тип сообщения не существует");
            }
        } catch (JsonProcessingException ex) {
            log.error(String.format("Ошибка конвертации JSON: %s", ex.getMessage()), ex);
            throw Exc.generate(ErrorType.JSON_CONVERT_ERROR, ex.getMessage());
        } catch (Exception ex) {
            log.error(String.format("Непредвиденная ошибка: %s", ex.getMessage()), ex);
            throw Exc.generate(ErrorType.UNEXPECTED_ERROR, ex.getMessage());
        }
    }
}

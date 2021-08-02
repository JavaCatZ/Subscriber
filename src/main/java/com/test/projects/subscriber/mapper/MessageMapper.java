package com.test.projects.subscriber.mapper;

import com.test.projects.subscriber.domain.dto.MessageDTO;
import com.test.projects.subscriber.domain.model.PurchaseMessage;
import com.test.projects.subscriber.domain.model.SubscriptionMessage;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MessageMapper {

    /**
     * Конвертирует ДТО-объект полученного сообщения в сущность с типом "purchase"
     *
     * @param messageDTO ДТО-объект полученного сообщения
     * @return сущность сообщения с типом "purchase"
     */
    PurchaseMessage toPurchaseMessageEntity(MessageDTO messageDTO);

    /**
     * Конвертирует ДТО-объект полученного сообщения в сущность с типом "subscription"
     *
     * @param messageDTO ДТО-объект полученного сообщения
     * @return сущность сообщения с типом "subscription"
     */
    SubscriptionMessage toSubscriptionMessageEntity(MessageDTO messageDTO);
}
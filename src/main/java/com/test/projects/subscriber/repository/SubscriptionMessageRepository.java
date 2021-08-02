package com.test.projects.subscriber.repository;

import com.test.projects.subscriber.domain.model.SubscriptionMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для сущностей типа "subscription"
 */
public interface SubscriptionMessageRepository extends JpaRepository<SubscriptionMessage, Long> {
}

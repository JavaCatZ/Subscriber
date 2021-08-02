package com.test.projects.subscriber.repository;

import com.test.projects.subscriber.domain.model.PurchaseMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для сущностей типа "purchase"
 */
public interface PurchaseMessageRepository extends JpaRepository<PurchaseMessage, Long> {
}

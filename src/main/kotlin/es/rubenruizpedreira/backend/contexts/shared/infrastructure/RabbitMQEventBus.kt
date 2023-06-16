package es.rubenruizpedreira.backend.contexts.shared.infrastructure

import es.rubenruizpedreira.backend.contexts.shared.domain.DomainEvent
import es.rubenruizpedreira.backend.contexts.shared.domain.EventBus
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RabbitMqEventBus @Autowired constructor(var rabbitTemplate: RabbitTemplate) : EventBus {
    override fun publish(event: DomainEvent) {
        rabbitTemplate.convertAndSend(event.eventName(), event.eventJson())
    }

    override fun publish(events: List<DomainEvent>) {
        for (event in events) {
            publish(event)
        }
    }
}
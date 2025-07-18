package cn.bugstack.trigger.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wuzeyu
 * @description 接受 MQ 消息
 * @github github.com/kkkkendei
 */
@Slf4j
@Component
public class TeamSuccessTopicListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${spring.rabbitmq.config.consumer.topic_team_success.queue}"),
            exchange = @Exchange(value = "${spring.rabbitmq.config.consumer.topic_team_success.exchange}", type = ExchangeTypes.TOPIC),
            key = "${spring.rabbitmq.config.consumer.topic_team_success.routing_key}"
        )
    )
    public void listen(String message) {
        log.info("接受消息: {}", message);
    }

}

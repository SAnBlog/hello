//package cn.sanii.hello.mq;
//
//import cn.sanii.hello.config.AmqpConfig;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.UUID;
///**
// * @Auther: shouliang.wang
// * @Date: 2018/5/8 17:23
// * @Description:
// * RabbitMQ生产者
// */
//@Component
//public class Sender implements RabbitTemplate.ConfirmCallback {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
//
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    public Sender(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.rabbitTemplate.setConfirmCallback(this);
//    }
//
//    public void send(String msg) {
//        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
//        LOGGER.info("send: " + correlationData.getId());
//        this.rabbitTemplate.convertAndSend(AmqpConfig.FOO_EXCHANGE, AmqpConfig.FOO_ROUTINGKEY, msg, correlationData);
//    }
//
//    /**
//     * @author shouliang.wang
//     * @date 2018/5/9 11:03
//     * @Description:
//     * 回调方法,确认消息是否被消费
//     */
//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        LOGGER.info("confirm: " + correlationData.getId());
//    }
//}
//
//

package com.btoy.wikimedia.consumer.config.errorHandling;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.errors.DeserializationExceptionHandler;
import org.apache.kafka.streams.processor.ProcessorContext;

import java.util.Map;
@Slf4j
public class SendToDeadLetterQueueExceptionHandler implements DeserializationExceptionHandler {

    public KafkaProducer<byte[], byte[]> dlqProducer;
    public String deadLetterQueueTopic;

    @Override
    public DeserializationHandlerResponse handle(ProcessorContext processorContext, ConsumerRecord<byte[], byte[]> record, Exception e) {
      log.warn("Message not consumed. \n  TaskId: {}, Topic: {}, Partition: {}, MessageOffset: {}",
                processorContext.taskId(), record.topic(), record.partition(), record.offset()
              );

      dlqProducer.send(new ProducerRecord<>(deadLetterQueueTopic, record.partition(), record.timestamp(), record.key(), record.value()));

      return DeserializationHandlerResponse.CONTINUE;
    }


    @Override
    public void configure(Map<String, ?> map) {}
}

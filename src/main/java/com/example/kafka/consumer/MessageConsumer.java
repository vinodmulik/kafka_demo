package com.example.kafka.consumer;

import com.example.kafka.common.KafkaProperties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

public class MessageConsumer {

    private KafkaConsumer<Integer,String> consumer = new KafkaConsumer<>(KafkaProperties.consumerProperties);
    private Collection<String> topics = Collections.singleton(KafkaProperties.TOPIC_NAME);
    private Duration timeout = Duration.ofMillis(100);

    public void consume(){
        consumer.subscribe(topics);
        while (true){
            ConsumerRecords<Integer,String> records = consumer.poll(timeout);
            records.iterator()
                    .forEachRemaining(record ->
                            System.out.printf("Topic : %s , Partition : %d , Offset : %d , Key : %d , Value : %s \n"
                                    ,record.topic(),record.partition(),record.offset(),record.key(),record.value()));
        }
    }
}

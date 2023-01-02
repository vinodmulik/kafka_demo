package com.example.kafka.producer;

import com.example.kafka.common.KafkaProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MessageProducer {

    private KafkaProducer<Integer,String> producer = new KafkaProducer<>(KafkaProperties.producerProperties);
    public void produce(Integer id,String message) throws ExecutionException, InterruptedException {
        ProducerRecord<Integer,String > record;
        if(id == null){
            record = new ProducerRecord<>(KafkaProperties.TOPIC_NAME,message);
        }
        else {
            record = new ProducerRecord<>(KafkaProperties.TOPIC_NAME,id,message);
        }
        try {
            System.out.println("Sending record to Kafka");
            Future<RecordMetadata> metadataFuture = producer.send(record,((recordMetadata, e) -> {
                if(e != null){
                    throw new RuntimeException(e);
                }
                System.out.println("Message sent to topic : " + recordMetadata.topic() + " with offset : " + recordMetadata.offset() + " and partition : " + recordMetadata.partition());
            }));
            /*RecordMetadata data =  metadataFuture.get();
            System.out.println("Message sent to topic : " + data.topic() + " with offset : " + data.offset());*/
        }catch (Exception e){
            System.err.println("Exception occured while sending message");
            throw e;
        }
    }
}

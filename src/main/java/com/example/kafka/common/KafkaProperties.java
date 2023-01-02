package com.example.kafka.common;

import java.util.Properties;

public class KafkaProperties {

    public static final String TOPIC_NAME = "demo-topic";
    public static Properties producerProperties = new Properties();
    public static Properties consumerProperties = new Properties();
    private static final String KEY_SERIALIZER = "org.apache.kafka.common.serialization.IntegerSerializer";
    private static final String KEY_DESERIALIZER = "org.apache.kafka.common.serialization.IntegerDeserializer";
    private static final String VALUE_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    private static final String VALUE_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
    private static final String BOOTSTRAP_SERVER = "localhost:9092";

    static {
        producerProperties.put("bootstrap.servers",BOOTSTRAP_SERVER);
        producerProperties.put("key.serializer",KEY_SERIALIZER);
        producerProperties.put("value.serializer",VALUE_SERIALIZER);

        consumerProperties.put("bootstrap.servers",BOOTSTRAP_SERVER);
        consumerProperties.put("key.deserializer",KEY_DESERIALIZER);
        consumerProperties.put("value.deserializer",VALUE_DESERIALIZER);
        consumerProperties.put("group.id","CG1");
    }
}

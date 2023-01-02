package com.example.kafka.consumer.test;

import com.example.kafka.consumer.MessageConsumer;

public class ConsumerTest {
    public static void main(String[] args) {
        var consumer = new MessageConsumer();
        System.out.println("Running Consumer");
        try {
            consumer.consume();
        }catch (Exception e){
            System.err.println("Error occured while running consumer");
            e.printStackTrace();
        }
    }
}

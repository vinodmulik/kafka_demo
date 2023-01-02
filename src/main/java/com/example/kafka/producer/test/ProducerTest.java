package com.example.kafka.producer.test;

import com.example.kafka.producer.MessageProducer;

import java.util.Scanner;
import java.util.stream.Stream;

public class ProducerTest {

    public static void main(String[] args) {
        var messageProducer = new MessageProducer();
        System.out.println("Running Producer");
        int seed = 0;
        /*Stream.iterate(0,num -> num < 10, num -> num+1)
                .forEach(num -> messageProducer.produce(Integer.toString(num),"Message" + num + " from Java Producer"));*/

        var loop = true;
        var counter = 1;
        try(Scanner scanner = new Scanner(System.in)) {
            while(loop){
                System.out.println("Enter 'send' to send a message or 'close' to exit !");
                var next = scanner.next();
                switch (next){
                    case "close":
                        loop = false;
                        System.out.println("Bye ! See you soon !");
                        break;
                    case "send":
                        System.out.println("Enter the message without any spaces!");
                        var message = scanner.next();
                        String[] arr = message.split(":");
                        Integer key = null;
                        var value = arr[0];
                        if(arr.length >1){
                            key = Integer.valueOf(arr[0]);
                            value = arr[1];
                        }
                        messageProducer.produce(key,value);
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

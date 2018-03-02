package com.lance.demo.kafka;

import org.junit.Test;

import static org.junit.Assert.*;

public class KafkaConsumerDemoTest {
    KafkaConsumerDemo kafkaConsumerDemo = new KafkaConsumerDemo();
    @Test
    public void consume() throws Exception {
        kafkaConsumerDemo.consume("test","111.231.194.152:9092");
    }

}
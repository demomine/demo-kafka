package com.lance.demo.kafka;

import org.junit.Test;

import static org.junit.Assert.*;

public class KafkaProducerDemoTest {
    KafkaProducerDemo kafkaProducerDemo = new KafkaProducerDemo();
    @Test
    public void produce() throws Exception {
        kafkaProducerDemo.produce("demo","47.94.151.242:9092");
    }

}
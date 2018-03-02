package com.lance.demo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerDemo {
    public void produce(String topic,String server) {
        Map<String, Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String, String> producer = new KafkaProducer<>(map);
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, 0, "key",i + "");
            producer.send(record);
            System.out.println(record + "send");
        }
    }
}

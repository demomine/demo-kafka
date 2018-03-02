package com.lance.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.*;

public class KafkaConsumerDemo {
    public void consume(String topic,String server) {
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.GROUP_ID_CONFIG, "default");
        KafkaConsumer kafkaConsumer = new KafkaConsumer(map);
        List<String> topics = new ArrayList<>();
        topics.add(topic);
        kafkaConsumer.subscribe(topics);
        while (true) {
            try {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
                if (records != null) {
                    for (ConsumerRecord<String, String> record : records) {
                        String value = record.value();
                        System.out.println(value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

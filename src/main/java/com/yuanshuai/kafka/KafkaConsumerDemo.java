package com.yuanshuai.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * 作者：Administrator
 * 时间：2018/9/25
 */
public class KafkaConsumerDemo extends Thread{

    private final KafkaConsumer kafkaConsumer;

    public KafkaConsumerDemo(String topic) {
        Properties properties=new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "kafka1:9092,kafka2:9092，kafka3:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"KafkaConsumerDemo2");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        kafkaConsumer=new KafkaConsumer(properties);
        kafkaConsumer.subscribe(Collections.singletonList(topic));
    }

    @Override
    public void run() {
        while(true){
            ConsumerRecords<Integer,String> consumerRecord=kafkaConsumer.poll(1000);
            for(ConsumerRecord record:consumerRecord){
                System.out.println("message receive:"+record.value());
             //   kafkaConsumer.commitAsync();
            }
        }
    }

    public static void main(String[] args) {
        new KafkaConsumerDemo("test").start();
    }

}

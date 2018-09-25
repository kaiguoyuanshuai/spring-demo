package com.yuanshuai.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

/*
 * 描述:
 * kafka 生成这
 * @auth zhengkk19738
 * @time 2018/9/25
 */
public class KafkaProducerDemo implements Runnable {

    public final KafkaProducer<Integer, String> kafkaProducer;

    private final String topic;
    private final boolean isAysnc;


    public KafkaProducerDemo(String topic, boolean isAysnc) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducerDemo01");
        properties.put(ProducerConfig.ACKS_CONFIG, "-1"); //自动
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        kafkaProducer = new KafkaProducer<Integer, String>(properties);
        this.topic = topic;
        this.isAysnc = isAysnc;
    }

    @Override
    public void run() {
        int num = 0 ;
        while (num <50 ){

        }
    }


    public static void main(String[] args) {

    }
}

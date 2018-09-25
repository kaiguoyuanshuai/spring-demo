package com.yuanshuai.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/*
 * 描述:
 * kafka 生成这
 * @auth zhengkk19738
 * @time 2018/9/25
 */
public class KafkaProducerDemo extends Thread {

    public final KafkaProducer<String, String> kafkaProducer;

    private final String topic;
    private final boolean isAysnc;


    public KafkaProducerDemo(String topic, boolean isAysnc) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9092,kafka2:9092，kafka3:9092");
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducerDemo01");
        properties.put(ProducerConfig.ACKS_CONFIG, "-1"); //自动
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        kafkaProducer = new KafkaProducer<String, String>(properties);
        this.topic = topic;
        this.isAysnc = isAysnc;
    }

    @Override
    public void run() {
        int num = 0;
        String messag = "message_" + num;
        String key = "key_" + num;
        while (num < 50) {
            try {
                RecordMetadata recordMetadata = kafkaProducer.send(new ProducerRecord<String,String>(topic,key, messag)).get();
                System.out.println("sync-offset:" + recordMetadata.offset() +
                        "->partition" + recordMetadata.partition());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            num++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public static void main(String[] args) {
        new KafkaProducerDemo("test", true).start();
    }
}

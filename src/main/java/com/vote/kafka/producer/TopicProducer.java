package com.vote.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private KafkaTemplate<String, String> kafkaTemplate;
    
    TopicProducer(KafkaTemplate<String, String> kafkaTemplate) {
    	this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message){
        kafkaTemplate.send(topicName, message);
    }

}
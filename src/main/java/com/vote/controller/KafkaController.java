package com.vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vote.kafka.producer.TopicProducer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    
	@Autowired
	private TopicProducer topicProducer;
    
    @GetMapping (value = "/send")
    public void send(){
        topicProducer.send("Votação Encerrada");
    }
}
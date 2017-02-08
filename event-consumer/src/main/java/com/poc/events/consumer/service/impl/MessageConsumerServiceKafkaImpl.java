package com.poc.events.consumer.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import com.poc.events.consumer.service.MessageConsumerService;

public class MessageConsumerServiceKafkaImpl implements MessageConsumerService{
	
	@KafkaListener( topics =  "topic-sample" )
	public void listen(@Payload String data) {
		//ONLY FOR TESTING PURPOSE
		System.out.println(data);
       
    }


	@Override
	public String activeListener(String Topic) {
		// TODO Auto-generated method stub
		return null;
	}
}

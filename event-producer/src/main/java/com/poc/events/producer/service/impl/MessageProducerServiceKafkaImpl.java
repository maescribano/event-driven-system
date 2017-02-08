package com.poc.events.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;

import com.poc.events.producer.config.Constants;

public class MessageProducerServiceKafkaImpl implements MessageProducerService{
	
	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;
	
	@Autowired
	private Environment env;

	@Override
	public void sendMessage(String message) {
		kafkaTemplate.send(env.getProperty(Constants.PROP_TOPIC_NAME), message);
		kafkaTemplate.flush();
	}
	
	

}

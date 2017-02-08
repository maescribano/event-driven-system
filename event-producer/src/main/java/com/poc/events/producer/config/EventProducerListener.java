package com.poc.events.producer.config;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

public class EventProducerListener implements ProducerListener<Integer, String> {

	@Override
	public boolean isInterestedInSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onError(String arg0, Integer arg1, Integer arg2, String arg3, Exception arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuccess(String arg0, Integer arg1, Integer arg2, String arg3, RecordMetadata arg4) {
		// TODO Auto-generated method stub
		
	}

}

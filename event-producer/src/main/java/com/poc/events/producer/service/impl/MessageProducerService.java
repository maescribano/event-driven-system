package com.poc.events.producer.service.impl;

public interface MessageProducerService {
	//TODO repensar salida desde listener
	public void sendMessage(String message);
}

package com.poc.events.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.poc.events.producer.service.impl.MessageProducerService;

@RestController
@RequestMapping("/")
public class EventProducerController {
	
	@Autowired
	private MessageProducerService messageProducerService;
	
	@RequestMapping(value="/message", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String helloWorldFromMicroserviceSample1(@RequestBody String message){
		messageProducerService.sendMessage(message);
		return "Message to kafka broker: " + message;	
	}

	

}

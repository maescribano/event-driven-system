package com.poc.events.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.poc.events.consumer.service.MessageConsumerService;
import com.poc.events.consumer.service.impl.MessageConsumerServiceKafkaImpl;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {


	@Autowired
	private Environment env;

	@Bean
	MessageConsumerService messageConsumerService(){
		return new MessageConsumerServiceKafkaImpl();
	}
	
	@Bean
	KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>>
	kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
				new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(3);
		factory.getContainerProperties().setPollTimeout(3000);
		return factory;
	}

	@Bean
	public ConsumerFactory<Integer, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();

		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, env.getProperty(Constants.PROP_BROKE_ENDPOINT));
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, env.getProperty(Constants.PROP_KEY_DESERIALIZER));
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, env.getProperty(Constants.PROP_VALUE_DESERIALIZER));
		props.put(ConsumerConfig.GROUP_ID_CONFIG, env.getProperty(Constants.PROP_CONSUMER_GROUP_ID));

		return props;
	}
}



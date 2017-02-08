package com.poc.events.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;

import com.poc.events.producer.service.impl.MessageProducerService;
import com.poc.events.producer.service.impl.MessageProducerServiceKafkaImpl;

/**
 * Created by mler on 8/2/17.
 */

@Configuration
@EnableKafka
public class KafkaConfig {

	
	@Autowired
	private Environment env;

    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, env.getProperty(Constants.PROP_BROKE_ENDPOINT));
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, env.getProperty(Constants.PROP_KEY_SERIALIZER));
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, env.getProperty(Constants.PROP_VALUE_SERIALIZER));
        return props;
    }


    
    @Bean
    public KafkaTemplate<Integer, String> kafkaTemplate() {
    	KafkaTemplate<Integer, String> kafkaTemplate = new KafkaTemplate<Integer, String>(producerFactory());
    	kafkaTemplate.setProducerListener(producerListener());
        return new KafkaTemplate<Integer, String>(producerFactory());
    }
    
    @Bean
    public ProducerListener<Integer, String> producerListener(){
    	return new EventProducerListener();
    }
    
    @Bean
    public MessageProducerService messageProducerService(){
    	return new MessageProducerServiceKafkaImpl();
    }

    

}

package com.appointmentservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;



public class KafkaProducerConfig {
	
	
	@Bean
    public NewTopic appointmentTopic(){
       return TopicBuilder.name("appointment-event").partitions(4).build();
    }

}

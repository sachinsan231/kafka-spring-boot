package com.kafka.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import lombok.Data;
import lombok.Getter;

@Configuration
@Data
@Getter
public class TopicConfig {

	@Value("${kafka.bootstrapAddress}")
	private String bootStrapAddress;
	
	@Value("${general.topic.name}")
	private String topicName;
	
	@Value("${user.topic.name}")
	private String UserTopicName;
	
	@Bean
	public NewTopic generalTopicName() {
		return TopicBuilder.name(topicName)
				.partitions(1).replicas(1).build();
	}
	
	@Bean
	public NewTopic userTopicName() {
		return TopicBuilder.name(UserTopicName).partitions(1).replicas(1).build();
	}
	
	//If not using spring boot
	
	/*
	 * @Bean public KafkaAdmin kafkaAdmin() { Map<String, Object> configs = new
	 * HashMap<>(); configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
	 * bootstrapAddress); return new KafkaAdmin(configs); }
	 */
}

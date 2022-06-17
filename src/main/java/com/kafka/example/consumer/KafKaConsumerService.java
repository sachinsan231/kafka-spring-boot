package com.kafka.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.example.AppConstants;
import com.kafka.example.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafKaConsumerService {

	@KafkaListener(topics = "${general.topic.name}", groupId = AppConstants.GROUP_ID)
	public void consume(String message) {
		log.info("Message : " + message);
	}

	@KafkaListener(topics = "${user.topic.name}", groupId = "${user.topic.group.id}",
			containerFactory = "userKafkaListenerContainerFactory")
	public void consume(User user) {
		log.info(String.format("User created -> %s", user));
	}
}

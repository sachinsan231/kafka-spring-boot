package com.kafka.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.example.AppConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafKaConsumerService {

	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
	public void consume(String message) {
		log.info("Message : "+message);
	}
}

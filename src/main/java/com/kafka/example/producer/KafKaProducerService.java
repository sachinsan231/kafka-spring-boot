/**
 * 
 */
package com.kafka.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.example.AppConstants;

/**
 * @author kadam.sachin
 *
 */
@Service
public class KafKaProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
	}
}

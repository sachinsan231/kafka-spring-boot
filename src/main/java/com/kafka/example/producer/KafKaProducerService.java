/**
 * 
 */
package com.kafka.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.example.AppConstants;
import com.kafka.example.model.User;

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

	/**
	 * send user data as String
	 * @param user
	 */
	public void sendMessage(User user) {
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME, user.toString());
		
	}
}

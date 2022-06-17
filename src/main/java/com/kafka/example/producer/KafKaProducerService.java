/**
 * 
 */
package com.kafka.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafka.example.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kadam.sachin
 *
 */
@Service
@Slf4j
public class KafKaProducerService {

	@Value(value = "${general.topic.name}")
    private String topicName;
	
	@Value(value = "${user.topic.name}")
    private String userTopicName;
	
	@Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		ListenableFuture<SendResult<String, String>> listenableFuture = this.kafkaTemplate.send(topicName, message);
		
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				log.info("SendMessage -> onSuccess : "+result);
				
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("SendMessage -> onFailure : "+ex.getMessage());
				
			}
		});
	}

	/**
	 * send user data as String
	 * @param user
	 */
	public void sendMessage(User user) {
		ListenableFuture<SendResult<String, User>> listenableFuture = this.userKafkaTemplate.send(userTopicName, user);
		
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {

			@Override
			public void onSuccess(SendResult<String, User> result) {
				log.info("SendMessage -> onSuccess : "+result);
				
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("SendMessage -> onFailure : "+ex.getMessage());
				
			}
		});
		
	}
}

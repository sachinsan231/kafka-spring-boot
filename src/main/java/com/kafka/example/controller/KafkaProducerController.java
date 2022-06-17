package com.kafka.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.example.model.User;
import com.kafka.example.producer.KafKaProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {
	
	@Autowired
	KafKaProducerService kafKaProducerService;
	
	@PostMapping("/publishString")
	public void sendStringMessageToTopic(@RequestParam("message") String message) {
		
		this.kafKaProducerService.sendMessage(message);
	}
	
	@PostMapping("/publishJSON")
	public void sendJsonMessageToTopic(@RequestBody User user) {
		this.kafKaProducerService.sendMessage(user);
	}

}

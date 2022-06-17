package com.kafka.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.example.producer.KafKaProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {
	
	@Autowired
	KafKaProducerService kafKaProducerService;
	
	@PostMapping("/publish")
	public void sendMessageToTopic(@RequestParam("message") String message) {
		
		this.kafKaProducerService.sendMessage(message);
	}

}

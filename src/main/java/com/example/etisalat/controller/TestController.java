package com.example.etisalat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.etisalat.service.FireBaseMessagingService;
import com.example.etisalat.service.pojo.Note;
import com.google.firebase.messaging.FirebaseMessagingException;

@RestController
public class TestController {
	private FireBaseMessagingService fireBaseMessagingService;

	@Autowired
	public TestController(FireBaseMessagingService fireBaseMessagingService) {
		this.fireBaseMessagingService = fireBaseMessagingService;
	}

	@PostMapping("/send-notification")
	public String sendNotification(@RequestBody Note note, @RequestParam String topic)
			throws FirebaseMessagingException {
		return fireBaseMessagingService.sendNotification(note, topic);
	}
}

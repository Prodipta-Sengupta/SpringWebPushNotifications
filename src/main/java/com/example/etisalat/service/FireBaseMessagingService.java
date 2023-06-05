package com.example.etisalat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.etisalat.service.pojo.Note;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class FireBaseMessagingService {
	private final FirebaseMessaging firebaseMessaging;

	@Autowired
	public FireBaseMessagingService(FirebaseMessaging firebaseMessaging) {
		super();
		this.firebaseMessaging = firebaseMessaging;
	}

	public String sendNotification(@RequestBody Note note, @RequestParam("topic") String topic)
			throws FirebaseMessagingException {
		Notification notification = Notification.builder().setTitle(note.getSubject()).setBody(note.getContent())
				.build();
		Message message = Message.builder().setTopic(topic).setNotification(notification).putAllData(note.getData())
				.build();

		return firebaseMessaging.send(message);

	}
}

package com.example;

import java.util.UUID;

/**
 * Created by Sebastian Börebäck on 2016-04-17.
 */
public class Message {
	private String id = UUID.randomUUID().toString();
	private String content;

	Message() {
	}

	public Message(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}

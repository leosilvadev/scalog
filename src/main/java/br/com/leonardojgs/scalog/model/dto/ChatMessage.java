package br.com.leonardojgs.scalog.model.dto;

public class ChatMessage {
	
	private String from;
	private String message;
	
	public ChatMessage() {}
	
	public ChatMessage(String from, String message) {
		super();
		this.from = from;
		this.message = message;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
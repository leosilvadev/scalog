package br.com.leonardojgs.scalog.model.services;

import java.util.Collection;

import br.com.leonardojgs.scalog.model.dto.ChatMessage;

public interface ChatService {

	void sendMessage(ChatMessage message);
	
	Collection<ChatMessage> findAll();
	
}

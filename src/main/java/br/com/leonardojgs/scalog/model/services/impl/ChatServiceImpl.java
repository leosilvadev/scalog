package br.com.leonardojgs.scalog.model.services.impl;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import br.com.leonardojgs.scalog.model.dto.ChatMessage;
import br.com.leonardojgs.scalog.model.services.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired private JmsTemplate jmsTemplate;
	
	@Override
	public void sendMessage(ChatMessage message) {
		jmsTemplate.convertAndSend(message);
	}

	@Override
	public Collection<ChatMessage> findAll() {
		return null;
	}

}

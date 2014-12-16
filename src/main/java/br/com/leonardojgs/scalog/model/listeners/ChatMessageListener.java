package br.com.leonardojgs.scalog.model.listeners;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.leonardojgs.scalog.model.converters.ChatMessageConverter;
import br.com.leonardojgs.scalog.model.dto.ChatMessage;

public class ChatMessageListener implements MessageListener {
	
	@Autowired private ChatMessageConverter converter;

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
				ChatMessage chatMessage = (ChatMessage) converter.fromMessage(message);
				System.out.println("New Message - BEGIN ------------------------------------------------------------");
				System.out.println("From: " + chatMessage.getFrom());
				System.out.println("Message: " + chatMessage.getMessage());
				System.out.println("New Message - END --------------------------------------------------------------");
				System.out.println();
				
			} catch (JMSException e) {
	            throw new IllegalArgumentException("Invalid message object");
				
			}
            
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
            
        }
    }

}

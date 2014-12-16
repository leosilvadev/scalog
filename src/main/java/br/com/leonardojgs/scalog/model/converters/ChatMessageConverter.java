package br.com.leonardojgs.scalog.model.converters;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;
import br.com.leonardojgs.scalog.model.dto.ChatMessage;
import br.com.leonardojgs.scalog.model.templates.JSONMapperTemplate;

@Service
public class ChatMessageConverter implements MessageConverter {

	@Autowired private JSONMapperTemplate jsonMapperTemplate;

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		return jsonMapperTemplate.mapToObject(message, ChatMessage.class);
	}

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		return jsonMapperTemplate.mapToMessage(object, session);
	}	
	
}
package br.com.leonardojgs.scalog.configuration;

import java.util.UUID;
import javax.annotation.Resource;
import javax.jms.MessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.leonardojgs.scalog.model.converters.ChatMessageConverter;
import br.com.leonardojgs.scalog.model.listeners.ChatMessageListener;
import br.com.leonardojgs.scalog.model.templates.JSONMapperTemplate;

@Configuration
@PropertySource("classpath:configuration/jms.properties")
public class JMSContext {

    @Resource private Environment environment;
    
	@Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDefaultDestination(new ActiveMQTopic(environment.getProperty("jms.topic.chat")));
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setMessageConverter(chatMessageConverter());
        return jmsTemplate;
    }
	
	@Bean
	@Scope(value="prototype")
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(environment.getProperty("jms.broker.url"));
        activeMQConnectionFactory.setClientID(UUID.randomUUID().toString());
        return activeMQConnectionFactory;
    }

	@Bean
	public MessageListenerContainer chatMessageListenerContainer(){
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestination(new ActiveMQTopic(environment.getProperty("jms.topic.chat")));
		container.setMessageListener(chatMessageListener());
		return container;
	}
	
	@Bean
	public MessageListener chatMessageListener(){
		return new ChatMessageListener();
	}
	
	@Bean
	public MessageConverter chatMessageConverter(){
		return new ChatMessageConverter();
	}
	
	@Bean
	public JSONMapperTemplate jsonMapperTemplate(){
		return new JSONMapperTemplate(new ObjectMapper());
	}
	
}

package br.com.leonardojgs.scalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardojgs.scalog.model.dto.ChatMessage;
import br.com.leonardojgs.scalog.model.services.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {
	
	@Autowired private ChatService chatService;

	@RequestMapping(method=RequestMethod.POST, value="/{message}")
	@ResponseStatus(HttpStatus.CREATED)
	public void send(@PathVariable String message){
		chatService.sendMessage(new ChatMessage("Sender", message));
	}
	
}

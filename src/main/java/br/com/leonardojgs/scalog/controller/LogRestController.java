package br.com.leonardojgs.scalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardojgs.scalog.model.dto.LogList;
import br.com.leonardojgs.scalog.model.services.LogService;

@RestController
@RequestMapping("/api/logs")
public class LogRestController {

	@Autowired private LogService logService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public LogList findAll(
			@RequestParam(defaultValue="0") Integer page,
			@RequestParam(defaultValue="10") Integer size){
		
		return new LogList(logService.findAll(new PageRequest(page, size)));
	}
	
}

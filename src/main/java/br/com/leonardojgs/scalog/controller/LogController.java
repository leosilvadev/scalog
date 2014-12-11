package br.com.leonardojgs.scalog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.leonardojgs.scalog.model.domains.Log;
import br.com.leonardojgs.scalog.model.services.LogService;

@Controller
@RequestMapping("/logs")
public class LogController {

	@Autowired private LogService logService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model, 
			@RequestParam(defaultValue="1") int page, 
			@RequestParam(defaultValue="10") int size){
		
		model.addAttribute("logsPage", logService.findAll(new PageRequest(page-1, size)));
		model.addAttribute("log", new Log());
		return "log/list";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/table")
	public String listInTable(Model model, 
			@RequestParam(defaultValue="1") int page, 
			@RequestParam(defaultValue="10") int size){
		
		model.addAttribute("logsPage", logService.findAll(new PageRequest(page-1, size)));
		model.addAttribute("log", new Log());
		return "log/table-logs";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute Log log, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			model.addAttribute("error", true);
			return "log/list";
		}
		logService.save(log);
		model.addAttribute("logs", logService.findAll(new PageRequest(0, 10)));
		return "redirect:logs";
	}
	
}

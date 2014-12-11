package br.com.leonardojgs.scalog.model.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Page;

import br.com.leonardojgs.scalog.model.domains.Log;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="log-list")
public class LogList {

	@XmlElementWrapper
	@XmlElement(name="log")
	private List<Log> logs;
	
	public LogList() {}
	
	public LogList(Page<Log> page) {
		super();
		this.logs = page.getContent();
	}
	
	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}
	
}

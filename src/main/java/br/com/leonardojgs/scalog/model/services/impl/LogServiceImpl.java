package br.com.leonardojgs.scalog.model.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.leonardojgs.scalog.model.domains.Log;
import br.com.leonardojgs.scalog.model.repositories.LogRepository;
import br.com.leonardojgs.scalog.model.services.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Autowired private LogRepository logRepository;
	
	@Override
	public Page<Log> findAll(Pageable pageable) {
		return logRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Log log) {
		logRepository.save(log);
	}
	
}

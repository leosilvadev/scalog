package br.com.leonardojgs.scalog.model.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.leonardojgs.scalog.model.domains.Log;

public interface LogService {

	void save(Log log);

	Page<Log> findAll(Pageable pageable);
	
}

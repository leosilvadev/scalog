package br.com.leonardojgs.scalog.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.leonardojgs.scalog.model.domains.Log;

@Repository
public interface LogRepository extends PagingAndSortingRepository<Log, Long> {

}

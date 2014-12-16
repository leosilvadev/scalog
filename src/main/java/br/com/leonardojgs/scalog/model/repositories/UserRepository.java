package br.com.leonardojgs.scalog.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.leonardojgs.scalog.model.domains.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUsername(String username);
	
}

package br.com.nautilus.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.nautilus.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	UserDetails findByUsr(String usr);
	
}

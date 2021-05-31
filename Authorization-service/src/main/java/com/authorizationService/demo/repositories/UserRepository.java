package com.authorizationService.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.authorizationService.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("From User u where u.username = ?1 and u.password = ?2")
	public User findUser(String userName, String password);
	
	@Query("From User u where u.username=?1")
	public User findByUname(String Uname);
}

package com.controle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.controle.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("select u from User u where u.email = :e and u.password = :p and u.machineName = :m")
	public User getUser(@Param("e") String email,@Param("p") String password,@Param("m") String machine);
	
	@Query("select u from User u where u.email = :e and u.password = :p")
	public User getUserEmailPAssword(@Param("e") String email,@Param("p") String password);
	
	public User getByMachineName (String machineName);
	
	public User getByUsername(String username);
	
	@Query("select u from User u where u.passforget = :e and u.passforgetActived = true")
	public User getByCode(@Param("e") String code);

}

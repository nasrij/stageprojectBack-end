package com.controle.metier;

import java.util.List;

import com.controle.entities.User;

public interface UserMetier {
	
	public User saveUser(User user);
	public User getUser(String email,String password,String machine);
	public User getUserEmailPassword(String email,String password);
	public User getUser(String Machine);
	public User UpdateUser(User user);
	public List<User> getUsers();
	public boolean DeleteUser(String MachineName);
	public User addRoleToUser(String machineName,String role);
	//public  boolean sendMail(String email ,String Message);
	public User getUserByusername(String username);
	public User getUserByCode(String code);
	
	

}

package com.controle.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.controle.dao.RoleRepository;
import com.controle.dao.UserRepository;
import com.controle.entities.Role;
import com.controle.entities.User;

@Service
public class UserMetierImpl implements UserMetier {

	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private RoleRepository roleRepository;
	@Override
	public User saveUser(User user) {		
		try{
			
			if((user.getMachineName() != "" || user.getMachineName() == null) && (user.getPassword() == null || user.getPassword()==""))
			{
				user.setPassword(userRepository.getByMachineName(user.getMachineName()).getPassword());
				return userRepository.save(user);
			}else
			{
				user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
				return userRepository.save(user);
			}
				
		}catch(Exception ex) {
			throw new RuntimeException("Erreur d'ajout");
		}
	}

	@Override
	public User getUser(String email, String password, String machine) {
			User u = userRepository.getUser(email, password, machine);
			if(u == null)
			{
				throw new RuntimeException("User inexistant");
			}
		return u;
	}

	@Override
	public User UpdateUser(User user) {		
		try{
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			return userRepository.save(user);
		}catch(Exception ex) {
			throw new RuntimeException("Erreur de mise à jour");
		}
	}

	@Override
	public boolean DeleteUser(String machineName) {		
		try {
			userRepository.delete(machineName);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Impossible de supression");
		}
	}

	@Override
	public User getUser(String machine) {
		
		User u = userRepository.getByMachineName(machine);
		if(u == null)
		{
			throw new RuntimeException("User inexistant");
		}
	return u;
	}

	@Override
	public User getUserEmailPassword(String email, String password) {
		User u = userRepository.getUserEmailPAssword(email, password);
		if(u == null)
		{
			throw new RuntimeException("User inexistant");
		}
	return u;
	}

	@Override
	public List<User> getUsers() {		
		return userRepository.findAll();
	}

	@Override
	public User addRoleToUser(String machineName, String role) {
		User u = userRepository.findOne(machineName);
		Role r =  roleRepository.findOne(role);
		u.getRoles().add(r);		
		return userRepository.save(u);
	}

	@Override
	public User getUserByusername(String username) {
		try{
			return userRepository.getByUsername(username);
		}catch(Exception ex) {
			throw new RuntimeException("User inexistant");
		}
	}

	@Override
	public User getUserByCode(String code) {
		User u = userRepository.getByCode(code);
		if(u == null)
		{
			throw new RuntimeException("User inexistant");
		}
	return u;
	}

	

}

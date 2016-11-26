package com.controle.service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entities.User;
import com.controle.metier.UserMetier;

@RestController
@RequestMapping(value="/user")
public class UserRestService {
	
	@Autowired
	private UserMetier userMetier;

	

	private final JavaMailSender javaMailSender;

    @Autowired
    UserRestService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${server.port}")
    private String serverPort;
    
    @RequestMapping(value="/mail",method=RequestMethod.POST )
    @CrossOrigin(origins = "http://localhost:8083")
    SimpleMailMessage send(@RequestBody User user ) { 
    	java.util.Date date= new java.util.Date();
		String ch = user.getMachineName()+(new Timestamp(date.getTime()).toString());
		user.setPassforget(encode(ch));
		user.setPassforgetActived(true);
    	if(userMetier.saveUser(user)!=null)
    	{
    		
    	 InetAddress ip=null;
         String hostname="";
         try {
             ip = InetAddress.getLocalHost();
             hostname = ip.getHostName();
             System.out.println("Your current IP address : " + ip.getHostAddress());
             System.out.println("Your current Hostname : " + hostname);
  
         } catch (UnknownHostException e) {
  
             e.printStackTrace();
         }
        
         System.out.println(ip.getHostAddress()+":"+serverPort+"/"+user.getPassforget());
         SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setReplyTo(user.getEmail());
        mailMessage.setFrom("nasreddinejrebi@gmail.com");
        mailMessage.setSubject("PASSWORD");
        mailMessage.setText("  http://"+ip.getHostAddress()+":8083/password?code="+user.getPassforget()+"  ");
        javaMailSender.send(mailMessage);
        return mailMessage;
    	}
    	return null;
    }
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		System.out.println(user.getPassword());
		
		return userMetier.saveUser(user);
	}

	@RequestMapping(value="/user",method=RequestMethod.GET)
	public User getUser(@RequestParam String email,@RequestParam String password,@RequestParam String machineName) {
		return userMetier.getUser(email, password,machineName);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public User login(@RequestParam String email,@RequestParam String password) {
		return userMetier.getUserEmailPassword(email, password);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public User UpdateUser(@RequestBody User user) {
		return userMetier.UpdateUser(user);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public boolean DeleteUser(@RequestParam String MachineName) {
		try {
			userMetier.DeleteUser(MachineName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@RequestMapping(value="/usermachine",method=RequestMethod.GET)
	public User getUser(@RequestParam String machineName) {
		return userMetier.getUser(machineName);
	}
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> getUsers() {
		return userMetier.getUsers();
	}
	@RequestMapping(value="/addRoleToUser",method=RequestMethod.POST)
	public User addRoleToUser(@RequestParam String machineName,@RequestParam String role) {
		return userMetier.addRoleToUser(machineName, role);
	}
	
	
	@RequestMapping(value="/getusername",method=RequestMethod.GET)
	 @CrossOrigin(origins = "http://localhost:8083")
	public User getByUserName(@RequestParam String username) {
		return userMetier.getUserByusername(username);
	}
	
	
	
	
	
	 private static String encode(String password)
	    {
	        byte[] uniqueKey = password.getBytes();
	        byte[] hash      = null;

	        try
	        {
	            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            throw new Error("No MD5 support in this VM.");
	        }

	        StringBuilder hashString = new StringBuilder();
	        for (int i = 0; i < hash.length; i++)
	        {
	            String hex = Integer.toHexString(hash[i]);
	            if (hex.length() == 1)
	            {
	                hashString.append('0');
	                hashString.append(hex.charAt(hex.length() - 1));
	            }
	            else
	                hashString.append(hex.substring(hex.length() - 2));
	        }
	        return hashString.toString();
	    }
	 
	 @RequestMapping(value="/getUserByCode",method=RequestMethod.GET)
	 @CrossOrigin(origins = "http://localhost:8083")
	 public User getUserByCode(@RequestParam String code) {
			return userMetier.getUserByCode(code);
		}
	 
}

package com.controle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entities.Session;
import com.controle.metier.SessionMetier;

@RestController
@RequestMapping(value="/session")
public class SessionRestRepository {
	
	@Autowired
	private SessionMetier sessionMetier;
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Session saveSession(@RequestBody Session p) {
		return sessionMetier.saveSession(p);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public boolean deleteSession(@RequestParam Long id,@RequestParam String machineName) {
		return sessionMetier.deleteSession(id, machineName);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Page<Session> getSessions(@RequestParam String machineName,@RequestParam int page,@RequestParam int size) {
		return sessionMetier.getSessions(machineName, page, size);
	}
	@RequestMapping(value="/deleteall",method=RequestMethod.POST)
	public void deleteAll(@RequestParam String machineName) {
		sessionMetier.deleteAll(machineName);
	}
	@RequestMapping(value="/last",method=RequestMethod.GET)
	public Session getLastSession(@RequestParam String machineName) {
		return sessionMetier.getLastSession(machineName);
	}
	
	

}

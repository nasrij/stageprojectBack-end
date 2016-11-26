package com.controle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entities.Keylogger;
import com.controle.metier.KeyloggerMetier;

@RestController
@RequestMapping(value="keylogger")
public class KeyloggerRestService {
	@Autowired
	private KeyloggerMetier keyloggerMetier;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Keylogger saveKeylogger(@RequestBody Keylogger k) {
		return keyloggerMetier.saveKeylogger(k);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public boolean deleteKeylogger(@RequestParam Long id) {
		return keyloggerMetier.deleteKeylogger(id);
	}
	@RequestMapping(value="",method=RequestMethod.GET)
	public Page<Keylogger> getKeylogers(@RequestParam String machineName,@RequestParam int page,@RequestParam int size) {
		return keyloggerMetier.getKeylogers(machineName, page, size);
	}
	
	@RequestMapping(value="/deleteAll",method=RequestMethod.POST)
	public boolean deleteAll(@RequestParam String machineName) {
		keyloggerMetier.deleteAll(machineName);
		return true;
	}
	
	

}

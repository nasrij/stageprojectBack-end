package com.controle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entities.Configuration;
import com.controle.metier.ConfigurationMetier;

@RestController
@RequestMapping(value="/configuration")
public class ConfigurationRestService {
	
	@Autowired
	private ConfigurationMetier configurationMetier;

	@RequestMapping(value="",method=RequestMethod.GET)
	public Configuration getConfiguration(@RequestParam Long id) {
		return configurationMetier.getConfiguration(id);
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Configuration saveConfiguration(@RequestBody Configuration c) {
		return configurationMetier.saveConfiguration(c);
	}
	
	

}

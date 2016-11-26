package com.controle.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.dao.ConfigurationRepository;
import com.controle.entities.Configuration;

@Service
public class ConfigurationMetierImpl  implements ConfigurationMetier{

	@Autowired
	private ConfigurationRepository config;
	@Override
	public Configuration getConfiguration(Long id) {
		Configuration c =config.getByIdConfig(id);
		if(c==null) throw new RuntimeException("Configuration Innexistant");
		return c;
	}

	@Override
	public Configuration saveConfiguration(Configuration c) {		
		return config.save(c);
	}

}

package com.controle.metier;

import com.controle.entities.Configuration;

public interface ConfigurationMetier {
	
	public Configuration getConfiguration(Long id);
	public Configuration saveConfiguration(Configuration c);

}

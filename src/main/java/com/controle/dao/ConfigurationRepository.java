package com.controle.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle.entities.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
	
	public Configuration getByIdConfig(Long id);

}

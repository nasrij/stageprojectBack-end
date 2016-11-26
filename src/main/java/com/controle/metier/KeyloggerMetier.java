package com.controle.metier;

import org.springframework.data.domain.Page;

import com.controle.entities.Keylogger;

public interface KeyloggerMetier {
	public Keylogger saveKeylogger(Keylogger k);
	public boolean deleteKeylogger(Long id);
	public Page<Keylogger> getKeylogers(String machineName,int page,int size);
	public void deleteAll(String machineName);

}

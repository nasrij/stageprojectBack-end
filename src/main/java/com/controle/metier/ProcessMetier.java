package com.controle.metier;

import org.springframework.data.domain.Page;

import com.controle.entities.Process;;

public interface ProcessMetier {
	public Process saveProcess(Process p);
	public boolean deleteProcess(Long id);
	public Page<Process> getProcess(String machineName,int page,int size);
	public void deleteAll(String machineName);

}
	


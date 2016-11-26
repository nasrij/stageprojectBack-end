package com.controle.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.controle.dao.ProcessRepository;
import com.controle.entities.Process;

@Service
public class ProcessMetierImpl implements ProcessMetier {

	@Autowired
	private ProcessRepository processRepository;
	
	@Override
	public Process saveProcess(Process p) {
		try{
			
			return processRepository.save(p);
		}catch(Exception ex)
		{
			throw new RuntimeException("Erreur d'ajout");
		}
		
	}

	@Override
	public boolean deleteProcess(Long id) {
		try{
			processRepository.delete(id);
			return true;
		}catch(Exception ex)
		{
			throw new RuntimeException("Erreur de suppression");
		}
		
	}

	@Override
	public Page<Process> getProcess(String machineName, int page, int size) {
		
		return processRepository.getProcess(machineName, new PageRequest(page, size));
	}

	@Override
	public void deleteAll(String machineName) {
		try{
			processRepository.deleteProcess(machineName);
		}catch(Exception ex)
		{
			throw new RuntimeException("Erreur de suppression");
		}
		
	}

}

package com.controle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entities.Process;
import com.controle.metier.ProcessMetier;

@RestController
@RequestMapping(value="process")
public class ProcessRestService {
	@Autowired
	private ProcessMetier processMetier;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Process saveProcess(@RequestBody Process p) {
		return processMetier.saveProcess(p);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public boolean deleteProcess(@RequestParam Long id) {
		return processMetier.deleteProcess(id);
	}
	@RequestMapping(value="",method=RequestMethod.GET)
	public Page<Process> getProcess(@RequestParam String machineName,@RequestParam int page,@RequestParam int size) {
		return processMetier.getProcess(machineName, page, size);
	}
	@RequestMapping(value="/deleteAll",method=RequestMethod.POST)
	public boolean deleteAll(@RequestParam String machineName) {
		processMetier.deleteAll(machineName);
		return true;
	}
	
	

}

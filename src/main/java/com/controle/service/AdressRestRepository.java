package com.controle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entities.Adress;
import com.controle.metier.AdressMetier;
@RestController
@RequestMapping(value="/adress")
public class AdressRestRepository {
	@Autowired
	private AdressMetier adressMetier;
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Adress saveAdress(@RequestBody Adress p) {
		return adressMetier.saveAdress(p);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public boolean deleteAdress(@RequestParam Long id,@RequestParam String machineName) {
		return adressMetier.deleteAdress(id, machineName);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Page<Adress> getAdress(@RequestParam String machineName,@RequestParam int page,@RequestParam int size) {
		return adressMetier.getAdress(machineName, page, size);
	}
	@RequestMapping(value="/deleteall",method=RequestMethod.POST)
	public void deleteAll(@RequestParam String machineName) {
		adressMetier.deleteAll(machineName);
	}
	@RequestMapping(value="/last",method=RequestMethod.GET)
	public Adress getLastAdress(@RequestParam String machineName) {
		return adressMetier.getLastAdress(machineName);
	}
	
	

}

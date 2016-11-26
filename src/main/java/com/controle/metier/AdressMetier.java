package com.controle.metier;

import org.springframework.data.domain.Page;

import com.controle.entities.Adress;

public interface AdressMetier {
	
	public Adress saveAdress(Adress p);
	public boolean deleteAdress(Long id,String machineName);
	public Page<Adress> getAdress(String machineName,int page,int size);
	public void deleteAll(String machineName);
	public Adress getLastAdress(String machineName);

}

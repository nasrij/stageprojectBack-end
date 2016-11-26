package com.controle.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.controle.dao.AdressRepository;
import com.controle.entities.Adress;
import com.controle.entities.Session;
@Service
public class AdressMetierImpl implements AdressMetier {

	@Autowired
	private AdressRepository adressRepository;
	@Override
	public Adress saveAdress(Adress p) {		
		try{
			return adressRepository.save(p);
		}catch(Exception ex)
		{
			throw new RuntimeException("Erreur d'ajout! ");
		}
	}

	@Override
	public boolean deleteAdress(Long id, String machineName) {
		try{
			Adress s = adressRepository.getOne(id);
			if(s.getUser().getMachineName() == machineName)
			{
				adressRepository.delete(id);
				return true;
			}else
				throw new RuntimeException("Erreur de suppression");
		}catch(Exception ex)
		{
			throw new RuntimeException("Erreur de suppression");
		}
	}

	@Override
	public Page<Adress> getAdress(String machineName, int page, int size) {
		try{
			return adressRepository.getAdress(machineName, new PageRequest(page, size));
		}catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public void deleteAll(String machineName) {
		adressRepository.deleteAdress(machineName);
		
	}

	@Override
	public Adress getLastAdress(String machineName) {
		return adressRepository.getLastAdress(machineName).get(0);
	}

}

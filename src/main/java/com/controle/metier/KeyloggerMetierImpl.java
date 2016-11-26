package com.controle.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.controle.dao.KeyloggerRepository;
import com.controle.entities.Keylogger;
@Service
public class KeyloggerMetierImpl implements KeyloggerMetier {
	@Autowired
	private KeyloggerRepository keyloggerRepository;
	
	@Override
	public Keylogger saveKeylogger(Keylogger k) {
		try{
		return keyloggerRepository.save(k);
	} catch (Exception e) {
		throw new RuntimeException("Erreur d'ajout !");
	}
	}

	@Override
	public boolean deleteKeylogger(Long id) {		
		try{
				keyloggerRepository.delete(id);
				return true;
		} catch (Exception e) {
			throw new RuntimeException("Erreur de suppression !");
		}
	}

	@Override
	public Page<Keylogger> getKeylogers(String machineName, int page, int size) {
		Page<Keylogger> keys = keyloggerRepository.getKeyloggers(machineName, new PageRequest(page, size));
		return keys;
	}

	@Override
	public void deleteAll(String machineName) {
		try{
			keyloggerRepository.deleteKeyloggers(machineName);
		}catch(Exception ex)
		{
			throw new RuntimeException("Erreur de suppression");
		}
		
	}

}

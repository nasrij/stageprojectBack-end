package com.controle.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.controle.dao.SessionRepository;
import com.controle.entities.Session;
@Service
public class SessionMetierImpl implements SessionMetier {

	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public Session saveSession(Session p) {
		try{
			return sessionRepository.save(p);
		}catch(Exception ex)
		{
			throw new RuntimeException("Erreur d'ajout! ");
		}
	}

	@Override
	public boolean deleteSession(Long id, String machineName) {
		try{
			Session s = sessionRepository.getOne(id);
			if(s.getUser().getMachineName() == machineName)
			{
				sessionRepository.delete(id);
				return true;
			}else
				throw new RuntimeException("Erreur de suppression");
		}catch(Exception ex)
		{
			throw new RuntimeException("Erreur de suppression");
		}
		
	}

	@Override
	public Page<Session> getSessions(String machineName, int page, int size) {
		try{
			return sessionRepository.getSession(machineName, new PageRequest(page, size));
		}catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public void deleteAll(String machineName) {
		
		sessionRepository.deleteSession(machineName);
	}

	@Override
	public Session getLastSession(String machineName) {	
		if(sessionRepository.getLastSession(machineName) == null)
		{
			return null;
		}
		return sessionRepository.getLastSession(machineName).get(0);
	}

}

package com.controle.metier;
import org.springframework.data.domain.Page;
import com.controle.entities.Session;

public interface SessionMetier {
	
	public Session saveSession(Session p);
	public boolean deleteSession(Long id,String machineName);
	public Page<Session> getSessions(String machineName,int page,int size);
	public void deleteAll(String machineName);
	public Session getLastSession(String machineName);

}

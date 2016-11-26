package com.controle.metier;

import org.springframework.data.domain.Page;

import com.controle.entities.File;

public interface FileMetier {
	
	public File saveFile(File f);
	public boolean deleteFile(Long id);
	public Page<File> getFiles(String machineName,int page,int size);
	public void deleteAll(String machineName);

}

package com.controle.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.controle.dao.FileRepository;
import com.controle.entities.File;
@Service
public class FileMetierImpl implements FileMetier {

	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public File saveFile(File f) {
		try {
			return fileRepository.save(f);
		} catch (Exception e) {
			throw new RuntimeException("Erreur d'ajout !");
		}
	}

	@Override
	public boolean deleteFile(Long id) {
		try {
			 fileRepository.delete(id);
			 return true;
		} catch (Exception e) {
			throw new RuntimeException("Erreur de suppression !");
		}
	}

	@Override
	public Page<File> getFiles(String machineName,int page,int size) {
		Page<File> ops = fileRepository.getfiles(machineName, new PageRequest(page, size)) ;
		return ops;
	}

	@Override
	public void deleteAll(String machineName) {
		try{
			fileRepository.deletefiles(machineName);
		}catch(Exception ex)
		{
			throw new RuntimeException("Erreur de suppression");
		}
		
	}

}

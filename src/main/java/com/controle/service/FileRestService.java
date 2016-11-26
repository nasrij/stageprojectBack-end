package com.controle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entities.File;
import com.controle.metier.FileMetier;

@RestController
@RequestMapping(value="/file")
public class FileRestService {
	@Autowired
	private FileMetier fileMetier;
@RequestMapping(value="/save",method=RequestMethod.POST)
	public File saveFile(@RequestBody File f) {
		return fileMetier.saveFile(f);
	}
@RequestMapping(value="/delete",method=RequestMethod.POST)
	public boolean deleteFile(@RequestParam Long id) {
		return fileMetier.deleteFile(id);
	}
@RequestMapping(value="",method=RequestMethod.GET)
	public Page<File> getFiles(@RequestParam String machineName,@RequestParam int page,@RequestParam int size) {
		return fileMetier.getFiles(machineName, page, size);
	}

@RequestMapping(value="/deleteAll",method=RequestMethod.POST)
public boolean deleteAll(@RequestParam String machineName) {

		fileMetier.deleteAll(machineName);
		return true;
	
}

	

}

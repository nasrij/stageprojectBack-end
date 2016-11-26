package com.controle.metier;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.controle.dao.ScreenshotRepository;
import com.controle.entities.Screenshot;
@Service
public class ScreenshotMetierImpl implements ScreenshotMetier {

	@Autowired
	private ScreenshotRepository screenshotRepository;
	
	@Override
	public Screenshot saveScreenshot(Screenshot p) {		
		try{
			return screenshotRepository.save(p);
		}catch(Exception ex){
			throw new RuntimeException("Erreur d'ajout");
		}
	}

	@Override
	public boolean deleteScreenshot(Long id) {
		try{
			
			 screenshotRepository.delete(id);
			 deletescreen();
			return true;
		}catch(Exception ex){
			throw new RuntimeException("Erreur de suppression");
		}
	}
	
	void deletescreen()
	{
		 FTPClient client = new FTPClient();
		 
		  try {

		client.connect("192.168.1.100");

		client.login("nasri", "123456789");
		 
		// Set a string with the file you want to delete

		String directoryPath = "/StageProject/src/main/resources/static/images/";

		// Delete file

		boolean exist = client.deleteFile(directoryPath+"nasri.png");

		// Notify user for deletion 
		if (exist) {
		    System.out.println("File '"+ directoryPath+"nasri.png" + "' deleted...");
		}
		// Notify user that file doesn't exist
		else 
			System.out.println("File '"+ directoryPath+"nasri.png" + "' doesn't exist...");
		 
		client.logout();

		  } catch (IOException e) {

		e.printStackTrace();

		  } finally {

		try {

		    client.disconnect();

		} catch (IOException e) {

		    e.printStackTrace();

		}
		  }
	}

	@Override
	public Page<Screenshot> getScreenshots(String machineName, int page, int size) {	
		return screenshotRepository.getScreenshots(machineName, new PageRequest(page, size));
	}
	
	@Override
	public void deleteAll(String machineName) {
		try{
			screenshotRepository.deleteScreenshots(machineName);
		}catch(Exception ex)
		{
			throw new RuntimeException(ex.getMessage());
		}
		
	}

}

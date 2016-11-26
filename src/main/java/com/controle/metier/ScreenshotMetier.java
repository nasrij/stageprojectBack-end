package com.controle.metier;

import org.springframework.data.domain.Page;
import com.controle.entities.Screenshot;

public interface ScreenshotMetier {

	public Screenshot saveScreenshot(Screenshot p);
	public boolean deleteScreenshot(Long id);
	public Page<Screenshot> getScreenshots(String machineName,int page,int size);
	public void deleteAll(String machineName);

}
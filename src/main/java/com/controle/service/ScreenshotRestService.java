package com.controle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entities.Screenshot;
import com.controle.metier.ScreenshotMetier;

@RestController
@RequestMapping(value="screenshot")
public class ScreenshotRestService {
	@Autowired
	private ScreenshotMetier screenshotMetier;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Screenshot saveScreenshot(@RequestBody Screenshot p) {
		return screenshotMetier.saveScreenshot(p);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public boolean deleteScreenshot(@RequestParam Long id) {
		
		return screenshotMetier.deleteScreenshot(id);
	}
	@RequestMapping(value="",method=RequestMethod.GET)
	public Page<Screenshot> getScreenshots(@RequestParam String machineName,@RequestParam int page,@RequestParam int size) {
		return screenshotMetier.getScreenshots(machineName, page, size);
	}
	
	@RequestMapping(value="/deleteAll",method=RequestMethod.POST)
	public boolean deleteAll(@RequestParam String machineName) {
		screenshotMetier.deleteAll(machineName);
		return true;
	}
	
	
	

}

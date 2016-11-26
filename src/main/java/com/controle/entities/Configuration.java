package com.controle.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Configuration implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConfig;
	private boolean process;
	private boolean keylogger;
	private boolean files;
	private boolean screenshot;
	private int intervalleScreenshot;
	private int intervallekeylogger;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date;
	
	
	public Long getIdConfig() {
		return idConfig;
	}
	public void setIdConfig(Long idConfig) {
		this.idConfig = idConfig;
	}
	public boolean isProcess() {
		return process;
	}
	public void setProcess(boolean process) {
		this.process = process;
	}
	public boolean isKeylogger() {
		return keylogger;
	}
	public void setKeylogger(boolean keylogger) {
		this.keylogger = keylogger;
	}
	public boolean isFiles() {
		return files;
	}
	public void setFiles(boolean files) {
		this.files = files;
	}
	public boolean isScreenshot() {
		return screenshot;
	}
	public void setScreenshot(boolean screenshot) {
		this.screenshot = screenshot;
	}
	public int getIntervalleScreenshot() {
		return intervalleScreenshot;
	}
	public void setIntervalleScreenshot(int intervalleScreenshot) {
		this.intervalleScreenshot = intervalleScreenshot;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getIntervallekeylogger() {
		return intervallekeylogger;
	}
	public void setIntervallekeylogger(int intervallekeylogger) {
		this.intervallekeylogger = intervallekeylogger;
	}
	public Configuration(boolean process, boolean keylogger, boolean files, boolean screenshot,
			int intervalleScreenshot, int intervallekeylogger, Date date) {
		super();
		this.process = process;
		this.keylogger = keylogger;
		this.files = files;
		this.screenshot = screenshot;
		this.intervalleScreenshot = intervalleScreenshot;
		this.intervallekeylogger = intervallekeylogger;
		this.date = date;
	}
	public Configuration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}

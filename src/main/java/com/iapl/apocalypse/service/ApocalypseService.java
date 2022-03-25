package com.iapl.apocalypse.service;

import java.util.List;

import com.iapl.apocalypse.models.Contamination;

import com.iapl.apocalypse.models.Survivor;

public interface ApocalypseService {
	
	public <T> T getRobotsList() throws Exception;
	
	public Survivor createNewSurvivor(Survivor surv) throws Exception;
	
	public List<Survivor> listAllSurviors() throws Exception;
	
	public List<Survivor> listInfectedSurviors() throws Exception;
	
	public List<Survivor> listNonInfectedSurviors() throws Exception;
	
	public Contamination reportInfection(Contamination inf) throws Exception;
	
	public List<Contamination> listOfInfectionsReport(Integer survivor_id)  throws Exception;
	
	public <T> T infectedSurvivorsPercentage() throws Exception;
	
	public <T> T nonInfectedSurvivorsPercentage() throws Exception;
	
	
	
		

}

package com.iapl.apocalypse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iapl.apocalypse.client.ApocalypseClient;
import com.iapl.apocalypse.models.Contamination;
import com.iapl.apocalypse.models.Inventory;
import com.iapl.apocalypse.models.Robot;
import com.iapl.apocalypse.models.Survivor;
import com.iapl.apocalypse.repositories.ContaminationRepository;
import com.iapl.apocalypse.repositories.InventoryRepository;
import com.iapl.apocalypse.repositories.SurvivorRepository;



@Service
public class ApocalypseServiceImpl implements ApocalypseService{
	
	
	@Autowired
	SurvivorRepository srvRepo;
	
	@Autowired
	ContaminationRepository contRepo;
	
	@Autowired
	InventoryRepository invRepo;
	
	
	@Value("${apocalypse.robot.url}")
	private String robot_url;
	
	
	@Autowired
	ApocalypseClient client;
	
//	
	@Override
	public List<Robot> getRobotsList() {
		
		
		
		List<Robot> robots = null;
		
		//=====================================================
	   
		try {
			
			robots = client.listRobotsFromAzure(robot_url);
	         
	         System.out.println("========== printing response from azure robot service ===========");
	         System.out.println(robots);
	    
		}catch(Exception ex) {
			
			 System.out.println("========== printing   exception ===========");
			 System.out.println(ex);
		}
		
		//=====================================================
		
		return robots ;
		
	}
	
	
	
	
	
	
	@Override
	public Survivor createNewSurvivor(Survivor surv) {
		
		surv.setInfected("No");
		Survivor sv = srvRepo.save(surv);
		
		//checking if this survivor has inventory
		if(surv.getInventory().size()> 0) {
			
			// Storing the inventory after creation of survivor
			for(Inventory inv :	surv.getInventory()) {
				
				inv.setSurvivor_id(sv.getID_survivor());
				invRepo.save(inv);
			}
		
		}
		
		return sv;
		
	}
	
	
	@Override
	public Survivor updateSurvivorLocation(HashMap<String,String> location){
		
		Survivor surv = srvRepo.getById(Integer.parseInt(location.get("survivor_id")));
		
		surv.setLatitude(location.get("latitude"));
		surv.setLongitude(location.get("longitude"));
		
		Survivor upsv = srvRepo.save(surv);
		
		return upsv;
	}
	
	
	@Override
	public List<Survivor> listInfectedSurviors(){
		
       for(Survivor surv :	srvRepo.pullInfectedSurvivors()) {
			
			surv.setInventory(invRepo.getBySurvivor(surv.getID_survivor()));
		}
		
		return srvRepo.pullInfectedSurvivors();
		
	}
	
	
	
	@Override
    public List<Survivor> listNonInfectedSurviors(){
		
       for(Survivor surv :	srvRepo.pullNonInfectedSurvivors()) {
			
			surv.setInventory(invRepo.getBySurvivor(surv.getID_survivor()));
		}
		
		return srvRepo.pullNonInfectedSurvivors();
		
	}
	
	
	
	@Override
	public List<Survivor> listAllSurviors(){
		
		for(Survivor surv :	srvRepo.findAll()) {
			
			surv.setInventory(invRepo.getBySurvivor(surv.getID_survivor()));
		}
		
		
		return srvRepo.findAll();
	}
	
	
	
	@Override
	public Contamination reportInfection(Contamination inf) {
		
		Integer survivor_id = inf.getSurvivor_id();
		
		Contamination savedInf = contRepo.save(inf);
		List<Contamination>  infections = new ArrayList<Contamination>();
		infections = listOfInfectionsReport(survivor_id);
		
		if(infections.size()>=3) {
			
			flagSurvivorAsInfected(survivor_id);
		}
		
		
		return savedInf;
		
	}
	
	
	
	@Override
	public HashMap<String,Integer> infectedSurvivorsPercentage(){
		
		HashMap<String,Integer> results = new HashMap<String,Integer>();
		
		// formulas :  Percentage = (number of infected / total survivor)*100
		
		 List<Survivor> infectedSurvivors = srvRepo.pullInfectedSurvivors();
		 List<Survivor> totalSurvivors    = srvRepo.findAll();
		 
		 Integer percent = (infectedSurvivors.size() *100)/ totalSurvivors.size();
		 
		 results.put("infectedSurvivors", infectedSurvivors.size());
		 results.put("totalSurvivors", totalSurvivors.size());
		 results.put("Percentage", percent);
		 
		
		
		 return results;
		
		
	}
	
	
	
	@Override
	public HashMap<String,Integer> nonInfectedSurvivorsPercentage(){
		
		HashMap<String,Integer> results = new HashMap<String,Integer>();
		
		// formulas :  Percentage = (number of non-infected / total survivor)*100
		
		 List<Survivor> nonInfectedSurvivors = srvRepo.pullNonInfectedSurvivors();
		 List<Survivor> totalSurvivors    = srvRepo.findAll();
		 
		 Integer percent = (nonInfectedSurvivors.size() *100)/ totalSurvivors.size();
		 
		 results.put("nonInfectedSurvivors", nonInfectedSurvivors.size());
		 results.put("totalSurvivors", totalSurvivors.size());
		 results.put("Percentage", percent);
		 
		
		
		 return results;
		
		
	}
	
	
	
	
	//This function returns the list of infections or contaminations.
	public List<Contamination> listOfInfectionsReport(Integer survivor_id){
		
		List<Contamination>  infections = new ArrayList<Contamination>();
		
		infections = contRepo.pullContaminationPerSurvivor(survivor_id);
		
		System.out.println("infections array length is : "+infections.size());
		
		return infections;
		
	}
	
	
	
	
    // This function is used to flag a survivor as infected
	public Survivor flagSurvivorAsInfected(Integer survivorID) {
		
		Survivor surv = srvRepo.getById(survivorID);
		
		surv.setInfected("Yes");
		
		return srvRepo.save(surv);
				
	}
	
	
	
	
	
	
	

}

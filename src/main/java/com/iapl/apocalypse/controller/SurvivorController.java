package com.iapl.apocalypse.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapl.apocalypse.models.Contamination;
import com.iapl.apocalypse.models.Robot;
import com.iapl.apocalypse.models.Survivor;
import com.iapl.apocalypse.service.ApocalypseService;


@RestController
@RequestMapping(value = "/apocalypse/v1")
public class SurvivorController {
	
	
	
	@Autowired
	ApocalypseService apocaService;
	
	
	// This function creates a new survivor in the DB
	@RequestMapping(value = "/survivors/create",method = RequestMethod.POST)
	public ResponseEntity<?>  createSurvivor(@RequestBody Survivor surv) {
		
        try{
			
        	Survivor createdSurv = apocaService.createNewSurvivor(surv);
			
			return new ResponseEntity<Object>( createdSurv,HttpStatus.OK);
			
		 }catch(Exception ex) {
			
			return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
			
		 }
			
	}
	
	
	
	
	@RequestMapping(value = "/survivors/update",method = RequestMethod.POST)
	public ResponseEntity<?>  updateSurvivorLocation(@RequestBody HashMap<String,String> surv) {
		
		try{
			
			Survivor updatedSurv = apocaService.updateSurvivorLocation(surv);
		
			
			return new ResponseEntity<Object>( updatedSurv,HttpStatus.OK);
			
		 }catch(Exception ex) {
			
			return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
			
		 }
	}
	
	
	
	
	
	
	// This function enable a survivor to report an infection
	@RequestMapping(value = "/infections",method = RequestMethod.POST)
	public ResponseEntity<?>  reportInfection(@RequestBody Contamination surv){
		
		     try{
				
		    	 Contamination reportedInf = apocaService.reportInfection(surv);
				
				return new ResponseEntity<Object>( reportedInf,HttpStatus.OK);
				
			 }catch(Exception ex) {
				
				return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
				
			 }
		
	}
	
	
	
	// This function pulls a list of reported contamination
	@RequestMapping(value = "/infections/{surv_id}",method = RequestMethod.GET)
	public ResponseEntity<?>  reportedContamination(@PathVariable Integer surv_id){
		
		     try{
				
		    	 List<Contamination> reportedInfs = apocaService.listOfInfectionsReport(surv_id);
				
				return new ResponseEntity<Object>( reportedInfs,HttpStatus.OK);
				
			 }catch(Exception ex) {
				
				return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
				
			 }
		
	}
	
	
	
	
	
	// This function retrieve a list of all survivors from the DB
	@RequestMapping(value = "/survivors",method = RequestMethod.GET)
	public ResponseEntity<?>  listSurvivors() {
		
		    try{
				
		    	List<Survivor> survList = apocaService.listAllSurviors();
				
				return new ResponseEntity<Object>( survList,HttpStatus.OK);
				
			 }catch(Exception ex) {
				
				return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
				
			 }
	
		
	}
	
	
	 // This function calculates and returns the percentage of infected survivors
	@RequestMapping(value = "/survivors/infectedPercentage",method = RequestMethod.GET)
	public ResponseEntity<?>  stats1Function(){
		
		   try{
				
			   HashMap<String,Integer> stats1Results = apocaService.infectedSurvivorsPercentage();
				
				return new ResponseEntity<Object>( stats1Results,HttpStatus.OK);
				
			 }catch(Exception ex) {
				
				return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
				
			 }
	}
	
	
	
	
	 // This function calculates and returns the percentage of non-infected survivors
		@RequestMapping(value = "/survivors/nonInfectedPercentage",method = RequestMethod.GET)
		public ResponseEntity<?>  stats2Function(){
			
			   try{
					
				   HashMap<String,Integer> stats2Results = apocaService.nonInfectedSurvivorsPercentage();
					
					return new ResponseEntity<Object>( stats2Results,HttpStatus.OK);
					
				 }catch(Exception ex) {
					
					return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
					
				 }
		}
		
		
		
		
		
		 // This function  returns the list of infected survivors
		@RequestMapping(value = "/survivors/infected",method = RequestMethod.GET)
		public ResponseEntity<?>  getInfectedSurvivors(){
			
			    try{
					
			    	List<Survivor> infectedSurvivors = apocaService.listInfectedSurviors();
					
					return new ResponseEntity<Object>( infectedSurvivors,HttpStatus.OK);
					
				 }catch(Exception ex) {
					
					return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
					
				 }
			
		}
		
		
		
		
		
		
		
		 // This function  returns the list of non-infected survivors
			@RequestMapping(value = "/survivors/nonInfected",method = RequestMethod.GET)
			public ResponseEntity<?>  getNonInfectedSurvivors(){
				
				try{
					
					List<Survivor> nonInfectedSurvivors = apocaService.listNonInfectedSurviors();
					
					return new ResponseEntity<Object>( nonInfectedSurvivors,HttpStatus.OK);
					
				 }catch(Exception ex) {
					
					return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
					
				 }
				
			}
			
			
			
			
			// This function  returns the list of robots from the azure service
			@RequestMapping(value = "/robots",method = RequestMethod.GET)
			public ResponseEntity<?>  getRobots(){
				List<Robot> robots = null;
				
				try{
						
		        	 robots = apocaService.getRobotsList();
					
					 return new ResponseEntity<Object>( robots,HttpStatus.OK);
					
				 }catch(Exception ex) {
					
					 return new ResponseEntity<Object>( ex,HttpStatus.UNPROCESSABLE_ENTITY);
					
				 }
				
			}
		
		
		
		
		
		
		
	
	

	

}

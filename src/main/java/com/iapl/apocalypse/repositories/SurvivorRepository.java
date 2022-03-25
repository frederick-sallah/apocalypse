package com.iapl.apocalypse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iapl.apocalypse.models.Survivor;

public interface SurvivorRepository  extends JpaRepository<Survivor, Integer>  {

	@Query(value="SELECT * FROM survivor  WHERE infected = 'Yes'", nativeQuery = true)
	List<Survivor> pullInfectedSurvivors();
	
	
	@Query(value="SELECT * FROM survivor  WHERE infected = 'No'", nativeQuery = true)
	List<Survivor> pullNonInfectedSurvivors();
	
	
}

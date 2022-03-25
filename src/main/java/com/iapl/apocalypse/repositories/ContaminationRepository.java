package com.iapl.apocalypse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iapl.apocalypse.models.Contamination;


public interface ContaminationRepository  extends JpaRepository<Contamination, Integer> {

	@Query(value="SELECT * FROM Contamination  WHERE survivor_id = ?1", nativeQuery = true)
	List<Contamination> pullContaminationPerSurvivor( Integer survID);
	

	
}

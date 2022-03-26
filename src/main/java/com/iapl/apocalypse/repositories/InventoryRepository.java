package com.iapl.apocalypse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iapl.apocalypse.models.Inventory;


public interface InventoryRepository  extends JpaRepository<Inventory, Integer> {
	
	@Query(value="SELECT * FROM inventory  WHERE survivor_id = ?1", nativeQuery = true)
	List<Inventory> getBySurvivor( Integer survID);

}

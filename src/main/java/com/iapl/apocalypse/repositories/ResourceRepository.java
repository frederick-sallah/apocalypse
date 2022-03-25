package com.iapl.apocalypse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iapl.apocalypse.models.Resource;


public interface ResourceRepository  extends JpaRepository<Resource, Integer> {
	

}

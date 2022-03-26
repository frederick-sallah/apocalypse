package com.iapl.apocalypse.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable{
	
	
	public Inventory() {}
	
	public Integer getID_inventory() {
		return ID_inventory;
	}

	public void setID_inventory(Integer iD_inventory) {
		ID_inventory = iD_inventory;
	}

	public Integer getSurvivor_id() {
		return survivor_id;
	}

	public void setSurvivor_id(Integer survivor_id) {
		this.survivor_id = survivor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Inventory(Integer iD_inventory, Integer survivor_id, String name) {
		super();
		ID_inventory = iD_inventory;
		this.survivor_id = survivor_id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Inventory [ID_inventory=" + ID_inventory + ", survivor_id=" + survivor_id + ", name=" + name + "]";
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "ID_inventory")
	private Integer ID_inventory;
	
	
	@Column(name = "survivor_id")
	private Integer survivor_id;
	
	@Column(name = "name")
	private String name;
	
	

}

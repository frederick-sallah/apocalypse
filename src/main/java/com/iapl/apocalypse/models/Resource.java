package com.iapl.apocalypse.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "resource")
public class Resource implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_resource")
	private Integer ID_resource;
	
	
	@Column(name = "survivor_id")
	private Integer survivor_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;

}

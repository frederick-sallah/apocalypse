package com.iapl.apocalypse.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Robot implements Serializable{


	@JsonProperty
	private String model;
	
	@JsonProperty
	private String serialNumber;
	
	@JsonProperty
	private String manufacturedDate;
	
	@JsonProperty
	private String category;
	
	
	public  Robot() {}
	

	@Override
	public String toString() {
		return "Robot [model=" + model + ", serialNumber=" + serialNumber + ", manufacturedDate=" + manufacturedDate
				+ ", category=" + category + "]";
	}


	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}

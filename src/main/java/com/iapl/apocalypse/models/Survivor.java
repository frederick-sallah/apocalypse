package com.iapl.apocalypse.models;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "survivor")
public class Survivor implements Serializable{
	
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_survivor")
	private Integer ID_survivor;
	
	
	@Column(name = "name")
	private String name;
	
	
	public  Survivor() {}
	



	public Survivor(Integer iD_survivor, String name, String age, String gender, String latitude, String longitude,
			String infected, List<Inventory> inventory, String date_created, String date_updated) {
		super();
		ID_survivor = iD_survivor;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.latitude = latitude;
		this.longitude = longitude;
		this.infected = infected;
		this.inventory = inventory;
		this.date_created = date_created;
		this.date_updated = date_updated;
	}




	@Override
	public String toString() {
		return "Survivor [ID_survivor=" + ID_survivor + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", infected=" + infected + "]";
	}


	public Integer getID_survivor() {
		return ID_survivor;
	}


	public void setID_survivor(Integer iD_survivor) {
		ID_survivor = iD_survivor;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getInfected() {
		return infected;
	}


	public void setInfected(String infected) {
		this.infected = infected;
	}


	public String getDate_created() {
		return date_created;
	}


	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}


	public String getDate_updated() {
		return date_updated;
	}


	public void setDate_updated(String date_updated) {
		this.date_updated = date_updated;
	}


	@Column(name = "age")
	private String age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	
	@Column(name = "infected")
	private String infected;
	
	

	@Transient
	@Column(name = "inventory")
	private transient List<Inventory> inventory;
	
	

	public List<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}


	@JsonIgnore
	@Transient
	@Column(name = "date_created")
	private transient String date_created;
	
	
	
	@JsonIgnore
	@Transient
	@Column(name = "date_updated")
	private transient String date_updated;
	
	

}

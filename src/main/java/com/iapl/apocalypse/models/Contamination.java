package com.iapl.apocalypse.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "contamination")
public class Contamination  implements Serializable{




	
	public  Contamination() {}


	@Override
	public String toString() {
		return "Contamination [ID_contamination=" + ID_contamination + ", survivor_id=" + survivor_id + ", reporter_id="
				+ reporter_id + ", reported_at=" + reported_at + "]";
	}

	public Contamination(Integer iD_contamination, Integer survivor_id, Integer reporter_id, Timestamp reported_at) {
		super();
		ID_contamination = iD_contamination;
		this.survivor_id = survivor_id;
		this.reporter_id = reporter_id;
		this.reported_at = reported_at;
	}

	public Integer getID_contamination() {
		return ID_contamination;
	}

	public void setID_contamination(Integer iD_contamination) {
		ID_contamination = iD_contamination;
	}

	public Integer getSurvivor_id() {
		return survivor_id;
	}

	public void setSurvivor_id(Integer survivor_id) {
		this.survivor_id = survivor_id;
	}

	public Integer getReporter_id() {
		return reporter_id;
	}

	public void setReporter_id(Integer reporter_id) {
		this.reporter_id = reporter_id;
	}

	public Timestamp getReported_at() {
		return reported_at;
	}

	public void setReported_at(Timestamp reported_at) {
		this.reported_at = reported_at;
	}

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_contamination")
	private Integer ID_contamination;
	
	
	@Column(name = "survivor_id")
	private Integer survivor_id;
	
	@Column(name = "reporter_id")
	private Integer reporter_id;
	
	@JsonIgnore
	@Column(name = "reported_at")
	@CreationTimestamp
	private Timestamp reported_at;
	
	
}

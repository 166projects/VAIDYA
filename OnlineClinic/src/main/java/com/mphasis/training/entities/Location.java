package com.mphasis.training.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String locId;
	@Column(nullable=false)
	private String location_name;
	@OneToMany(mappedBy="location")
	private List<Clinic> clinics;
	public String getLocId() {
		return locId;
	}
	public void setLocId(String locId) {
		this.locId = locId;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public List<Clinic> getClinics() {
		return clinics;
	}
	public void setClinics(List<Clinic> clinics) {
		this.clinics = clinics;
	}
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", location_name=" + location_name + ", clinics=" + clinics + "]";
	}

}

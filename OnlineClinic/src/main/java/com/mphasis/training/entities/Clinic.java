package com.mphasis.training.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Clinic implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable=true)
	@GeneratedValue(strategy = GenerationType.AUTO)

	private String cId;
	
	@Column(nullable=false)
	private String clinic_name;
	@Column(nullable=false)
	private String clinic_address;
	@ManyToOne
	private Location location;

	@OneToMany(mappedBy = "clinic")
	private List<Doctor> doctors;

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}

	public String getClinic_address() {
		return clinic_address;
	}

	public void setClinic_address(String clinic_address) {
		this.clinic_address = clinic_address;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Clinic [cId=" + cId + ", clinic_name=" + clinic_name + ", clinic_address=" + clinic_address
				+ ", location=" + location + ", doctors=" + doctors + "]";
	}
	
	
}

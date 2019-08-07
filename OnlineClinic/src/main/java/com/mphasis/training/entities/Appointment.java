package com.mphasis.training.entities;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Appointment {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String aId;

	private String disease;
	@Column(nullable=false)
	private LocalDateTime appointment_Time;
	private String remark;
	private String appointment_status;
	
	@ManyToOne
	private Doctor doctor;
	
	@ManyToOne
	private Patient patient;
	
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public LocalDateTime getAppointment_Time() {
		return appointment_Time;
	}
	public void setAppointment_Time(LocalDateTime appointment_Time) {
		this.appointment_Time = appointment_Time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAppointment_status() {
		return appointment_status;
	}
	public void setAppointment_status(String appointment_status) {
		this.appointment_status = appointment_status;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public String toString() {
		return "Appointment [aId=" + aId + ", disease=" + disease + ", appointment_Time=" + appointment_Time
				+ ", remark=" + remark + ", appointment_status=" + appointment_status + ", doctor=" + doctor
				+ ", patient=" + patient + "]";
	}

}

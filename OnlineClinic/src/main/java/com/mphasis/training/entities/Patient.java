package com.mphasis.training.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String pId;
	@Column(nullable=false)
	private int age;
	@Column(nullable=false)
	private int weight;
	private Clob record;
	
	@OneToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointment;
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Clob getRecord() {
		return record;
	}
	public void setRecord(Clob record) {
		this.record = record;
	}
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	
	
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Patient [pId=" + pId + ", age=" + age + ", weight=" + weight + ", record=" + record + ", appointment="
				+ appointment + "]";
	}

}

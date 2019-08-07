package com.mphasis.training.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String rId;
	@Column(nullable=false)
	private String role_name;
	

	@OneToOne
	@JoinColumn(name="member_id")
	private Member member;

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", role_name=" + role_name + "]";
	}
	
	

}

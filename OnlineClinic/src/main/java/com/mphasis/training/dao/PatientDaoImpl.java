package com.mphasis.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.training.entities.Patient;
import com.mphasis.training.entities.Patient;
import com.mphasis.training.entities.Patient;

public class PatientDaoImpl implements PatientDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertPatient(Patient patient) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(patient);
		tr.commit();
	}

	public void updatePatient(int pid) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(pid);
		tr.commit();
	}

	public List<Patient> getPatients() {
		Session session = sessionFactory.openSession();
		System.out.println("Inside Dao");
		List<Patient> patients = session.createCriteria(Patient.class).list();
		return patients;

	}

	public Patient getPatientById(int pid) {
		Session session = sessionFactory.openSession();
		System.out.println("Inside Dao");
		Patient patients = (Patient) session.get(Patient.class, pid);
		return patients;

	}
}

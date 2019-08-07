package com.mphasis.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.mphasis.training.entities.Clinic;

public class ClinicDaoImpl implements ClinicDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertClinic(Clinic clinic) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(clinic);
		tr.commit();
	}

	public void updateClinic(Clinic clinic) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Clinic clinic1 = (Clinic) session.get(Clinic.class, clinic.getcId());
		session.update(clinic1);
		tr.commit();
	}

	public void deleteClinic(int cid) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Clinic clinic = (Clinic) session.get(Clinic.class, cid);
		session.delete(clinic);
		tr.commit();
	}

	public List<Clinic> getClinics() {
		Session session = sessionFactory.openSession();
		System.out.println("Inside Dao");
		List<Clinic> clinics = session.createCriteria(Clinic.class).list();
		return clinics;
	}

}

package com.mphasis.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.dao.DoctorDao;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(doctor);
		tr.commit();

	}
		
	public void updateDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Doctor doctor1 = (Doctor) session.get(Doctor.class, doctor.getdId());
		session.update(doctor1);
		tr.commit();
	}

	public void deleteDoctor(int did) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Doctor doctor = (Doctor) session.get(Doctor.class, did);
		session.delete(doctor);
		tr.commit();
	}
	
	public List<Doctor> getDoctors()
	{
		Session session = sessionFactory.openSession();
		System.out.println("Inside Dao");
		List<Doctor> doctors = session.createCriteria(Doctor.class).list();
		return doctors;

	}
	public List<Doctor> getDoctorByClinic(int cid)
	{
		Session session = sessionFactory.openSession();
		System.out.println("Inside Dao");
		List<Doctor> doctors = (List<Doctor>) session.get(Doctor.class,cid);
		return doctors;

	}


}

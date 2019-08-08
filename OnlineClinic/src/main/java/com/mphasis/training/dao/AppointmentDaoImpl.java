package com.mphasis.training.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Appointment;
@Repository
@Transactional
public class AppointmentDaoImpl implements AppointmentDao {
	@Autowired
	SessionFactory sessionFactory;
		public void insertAppointment(Appointment appointment) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			session.save(appointment);
			session.close();
		}
		public void updateAppointment(Appointment appointment) {
			Session session = sessionFactory.openSession();
			session.update(appointment);
			session.close();
		}
		
		public List<Appointment> getAppointments()
		{
			Session session = sessionFactory.openSession();
			System.out.println("Inside Dao");
			List<Appointment> appointments = session.createCriteria(Appointment.class).list();
			session.close();
			return appointments;
			
		}
		public List<Appointment> getAppointmentByDate(LocalDateTime appointment_time)
		{
			
			Session session = sessionFactory.openSession();
			System.out.println("Inside Dao");
			DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
			String formattedDateTime = appointment_time.format(format);
			List<Appointment> appointments = session.createCriteria(Appointment.class,formattedDateTime).list();
			session.close();
			return appointments;
			
		}

		public void deleteAppointment(int aid) {
			Session session = sessionFactory.openSession();
			Appointment appointment=(Appointment)session.get(Appointment.class, aid);
			session.delete(appointment);
			session.close();
		}
		
	}



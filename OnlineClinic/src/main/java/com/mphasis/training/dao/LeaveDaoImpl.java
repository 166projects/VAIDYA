package com.mphasis.training.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Leave;

public class LeaveDaoImpl implements LeaveDao {
	@Autowired
	SessionFactory sessionFactory;
	public void insertLeave(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	public void approveLeave(Leave leave) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Leave leave1= (Leave) session.get(Leave.class, leave.getlId());
//		leave1.setReason(leave.getReason());
		leave1.setLeave_status(1);
		session.update(leave);
		tr.commit();

	}

	public void denyLeave(Leave leave) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Leave leave1= (Leave) session.get(Leave.class, leave.getlId());
//		leave1.setReason(leave.getReason());
		leave1.setLeave_status(0);
		session.update(leave);
		tr.commit();
	}

}

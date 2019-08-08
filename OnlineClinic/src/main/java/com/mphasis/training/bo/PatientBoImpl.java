package com.mphasis.training.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.PatientDao;
import com.mphasis.training.entities.Patient;
@Service

public class PatientBoImpl implements PatientBo {
@Autowired
PatientDao patientDao;
	public void insertPatient(Patient patient) {
		// TODO Auto-generated method stub
		patientDao.insertPatient(patient);
	}

	public void updatePatient(int pid) {
		// TODO Auto-generated method stub
		patientDao.updatePatient(pid);
	}

	public List<Patient> getPatientsByName(String firstname) {
		// TODO Auto-generated method stub
		return patientDao.getPatientsByName(firstname);
	}

	public Patient getPatientById(int pid) {
		// TODO Auto-generated method stub
		return patientDao.getPatientById(pid);
	}

}

package com.mphasis.training.bo;

import java.util.List;
import com.mphasis.training.entities.Patient;

public interface PatientBo {
	public void insertPatient(Patient patient);
	public void updatePatient(int pid);
	public List<Patient> getPatientsByName(String firstname);
	public Patient getPatientById(int pid);
	
}



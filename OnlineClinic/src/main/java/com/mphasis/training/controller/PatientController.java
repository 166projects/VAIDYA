

package com.mphasis.training.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.bo.PatientBo;


@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientBo patientBo;
	@RequestMapping(value="/patients",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> getAll()
	{
	return patientBo.getAssignments();
	}


@RequestMapping(value="/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
public void addPatient(@RequestBody Patient patient)
{
 patientBo.insertPatient(patient);
}


@RequestMapping(value="/add",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
public void updatePatient(@RequestBody Patient patient)
{
  Patient patient=patientBo.getPatientsById(patient.getpId());
	if(patient!=null)
 patientBo.updatePatient(patient);
	else
	throw new BusinessException("no patient found");

}

@RequestMapping(value="/add/{pId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public void deletePatient(@PathVariable("pId") int pId)
{

	patientBo.deletePatient(pId);

}


@RequestMapping(value="/patient/{pId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public Patient getpatientsById(@PathVariable("pId") int  pId)
{
	
		 return patientBo.getPatientsById(pId);

}

@RequestMapping(value="/patient/{firstname}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public Patient getPatientByName(@PathVariable("firstname") String  firstname)
{
	
		 return patientBo.getPatientByName(firstname);

}


}

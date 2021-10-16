package in.nareshit.dinesh.service;

import java.util.List;

import in.nareshit.dinesh.entity.Patient;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IPatientService {
	Long savePatient(Patient patient);

	void updatePatient(Patient patient);

	void deletePatient(Long id);

	Patient getOnePatient(Long id);

	List<Patient> getAllPatients();
}

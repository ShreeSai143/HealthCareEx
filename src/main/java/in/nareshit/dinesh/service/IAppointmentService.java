package in.nareshit.dinesh.service;

import java.util.List;

import in.nareshit.dinesh.entity.Appointment;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IAppointmentService {
	Long saveAppointment(Appointment appointment);
	void updateAppointment(Appointment appointment);
	void deleteAppointment(Long id);
	Appointment getOneAppointment(Long id);
	List<Appointment> getAllAppointments();
	List<Object[]> getAppoinmentsByDoctor(Long docId);
}

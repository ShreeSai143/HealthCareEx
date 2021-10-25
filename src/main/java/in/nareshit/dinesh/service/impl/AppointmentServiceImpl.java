package in.nareshit.dinesh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nareshit.dinesh.entity.Appointment;
import in.nareshit.dinesh.repo.AppointmentRepository;
import in.nareshit.dinesh.service.IAppointmentService;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Service
public class AppointmentServiceImpl implements IAppointmentService {
	@Autowired
	private AppointmentRepository repo;

	@Override
	@Transactional
	public Long saveAppointment(Appointment appointment) {
		return repo.save(appointment).getId();
	}

	@Override
	@Transactional
	public void updateAppointment(Appointment appointment) {
		repo.save(appointment);
	}

	@Override
	@Transactional
	public void deleteAppointment(Long id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public Appointment getOneAppointment(Long id) {
		return repo.findById(id).get();
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public List<Appointment> getAllAppointments() {
		return repo.findAll();
	}
	
	@Override
	public List<Object[]> getAppoinmentsByDoctor(Long docId) {
		return repo.getAppoinmentsByDoctor(docId);
	}
}

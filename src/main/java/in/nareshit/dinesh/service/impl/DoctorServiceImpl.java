package in.nareshit.dinesh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.dinesh.constants.UserRoles;
import in.nareshit.dinesh.entity.Doctor;
import in.nareshit.dinesh.entity.User;
import in.nareshit.dinesh.exception.DoctorNotFoundException;
import in.nareshit.dinesh.repo.DoctorRepository;
import in.nareshit.dinesh.service.IDoctorService;
import in.nareshit.dinesh.service.IUserService;
import in.nareshit.dinesh.util.MyCollectionsUtil;
import in.nareshit.dinesh.util.UserUtil;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository repo;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserUtil util;
	
	@Override
	public Long saveDoctor(Doctor doc) {
		Long id = repo.save(doc).getId();
		if(id!=null) {
			User user = new User();
			user.setDisplayName(doc.getFirstName()+" "+doc.getLastName());
			user.setUsername(doc.getEmail());
			user.setPassword(util.genPwd());
			user.setRole(UserRoles.DOCTOR.name());
			userService.saveUser(user);
			// TODO : Email part is pending
		}
		return id;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return repo.findAll();
	}

	@Override
	public void removeDoctor(Long id) {
		repo.delete(getOneDoctor(id));
	}

	@Override
	public Doctor getOneDoctor(Long id) {
		return repo.findById(id).orElseThrow(
				()->new DoctorNotFoundException(id+", not exist")
				);
	}

	@Override
	public void updateDoctor(Doctor doc) {
		if(repo.existsById(doc.getId()))
			repo.save(doc);
		else 
			throw new DoctorNotFoundException(doc.getId()+", not exist"); 
	}
	
	@Override
	public Map<Long, String> getDoctorIdAndNames() {
		List<Object[]> list = repo.getDoctorIdAndNames();
		return MyCollectionsUtil.convertToMapIndex(list);
	}

}

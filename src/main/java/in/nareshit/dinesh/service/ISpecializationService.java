package in.nareshit.dinesh.service;

import java.util.List;

import in.nareshit.dinesh.entity.Specialization;

public interface ISpecializationService {

	public Long saveSpecialization(Specialization spec);
	
	public List<Specialization> getAllSpecializations();
	
	public void removeSpecialization(Long id);
	
	public Specialization getOneSpecialization(Long id);
	
	public void updateSpecialization(Specialization spec);
	
	
}

package in.nareshit.dinesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.dinesh.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

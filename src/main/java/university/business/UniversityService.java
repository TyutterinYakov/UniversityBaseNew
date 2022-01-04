package university.business;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.dao.FacultyRepository;
import university.dao.UniversityRepository;
import university.domain.Faculty;
import university.domain.University;



@Service
public class UniversityService {
	
	@Autowired
	private UniversityRepository universityRepo;
	
	@Autowired
	private FacultyRepository faculty;
	
	@Transactional(readOnly=true)
	 public List<University> findUniversities(){
		 return universityRepo.findAll();
	 }
	
	@Transactional(readOnly = true)
	public List<University> findFullUniversities(){
		return universityRepo.findFullList();
	}
	
	@Transactional(readOnly=true)
	public List<Faculty> findFaculties(){
		
		return faculty.findAll();
	}
	
	@Transactional(readOnly=true)
	public University getUniversity(Long unId) {
		University u = universityRepo.findById(unId).get();
		Hibernate.initialize(u.getFaculties());
		return u;
	}

	
	
	
	@Transactional(readOnly=true)
	public Faculty getFaculty(Long facultyId) {
		Optional<Faculty> byId = faculty.findById(facultyId);
		Faculty fc = byId.get();
		Hibernate.initialize(fc.getUniversity());
		return fc;
	}
}

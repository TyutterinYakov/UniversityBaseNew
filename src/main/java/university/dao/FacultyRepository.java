package university.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import university.domain.Faculty;





public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	
}

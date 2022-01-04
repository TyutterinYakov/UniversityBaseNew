package university.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import university.domain.University;


@Repository
public interface UniversityRepository extends JpaRepository<University, Long>{
	@Query(name="University.findAllWithFaculty", value="select u from University u "
			+ "left join fetch u.faculties")
	List<University> findFullList();
}

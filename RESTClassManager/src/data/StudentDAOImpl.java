package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Student;

@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Student> indexStudents() {
		String query = "SELECT s FROM Student s";
		return em.createQuery(query, Student.class).getResultList();
	}

}

package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.ClassRoster;
import entities.Teacher;

@Transactional
@Repository
public class TeacherDAOImpl implements TeacherDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<ClassRoster> showClassesByTeacherId(int tid) {
		String query = "SELECT t FROM Teacher t WHERE t.id = :tid";
		List <Teacher> teachers = em.createQuery(query, Teacher.class)
				.setParameter("tid", tid)
				.getResultList();
		if (teachers != null) {
			return teachers.get(0).getClasses();
		}
		return null;
	}
}

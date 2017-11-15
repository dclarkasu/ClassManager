package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Student;

public class StudentTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Student stud;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("CMPU");
		em = emf.createEntityManager();
	}

	@After
	public void tearDown() {
		em.close();
		emf.close();
	}

	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}

	@Test
	public void Student_Connected_To_DB() {
		stud = em.find(Student.class, 1);
		assertEquals(stud.getFirstName(), "Lil Bobbie");
		assertEquals(stud.getLastName(), "Bobberson");
	}

	@Test
	public void Student_To_grade() {
		stud = em.find(Student.class, 1);
		assertEquals(stud.getGrade().getLevel(), 6);
	}

	@Test
	public void test_Student_To_ClassRoster() {
		stud = em.find(Student.class, 1);
		assertEquals(stud.getClassRoster().getName(), "Spanish");
		assertEquals(stud.getClassRoster().getTeacher().getFirstName(), "Annie");
		assertEquals(stud.getClassRoster().getWeekDays().get(0).getName(), "Monday");
	}

	@Test
	public void test_Student_To_Roles() {
		stud = em.find(Student.class, 1);
		assertEquals(stud.getStudentRoles().get(0).getRole().getName(), "Hall Monitor");
		assertNotNull(stud.getRoles());
		assertEquals(stud.getRoles().get(0).getDescription(), "Walk it like you own it");
	}

}

package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Teacher;

public class TeacherTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Teacher teach;

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
	public void teacher_Connected_To_DB() {
		teach = em.find(Teacher.class, 1);
		assertEquals(teach.getFirstName(), "Annie");
		assertEquals(teach.getLastName(), "Anners");
	}

	@Test
	public void teacher_To_ClassRoster() {
		teach = em.find(Teacher.class, 1);
		assertEquals(teach.getClasses().get(0).getName(), "Spanish");
		assertEquals(teach.getClasses().get(0).getClassSchedules().get(0).getWeekDay().getName(), "Monday");
	}

	@Test
	public void test_Teacher_To_Student() {
		teach = em.find(Teacher.class, 1);
		assertEquals(teach.getClasses().get(0).getStudents().get(0).getFirstName(), "Lil Bobbie");
		assertEquals(teach.getClasses().get(0).getStudents().get(0).getGrade().getLevel(), 6);
		assertEquals(teach.getClasses().get(0).getStudents().get(0).getRoles().get(0).getName(), "Hall Monitor");
		assertEquals(teach.getClasses().get(0).getStudents().get(0).getRoles().get(0).getStudents().get(0).getClassRoster().getName(), "Spanish");
	}

	@Test
	public void test_Student_To_Roles() {
		teach = em.find(Teacher.class, 1);
		assertEquals(teach.getUser().getUsername(), "teacherlady");
		assertEquals(teach.getUser().getPassword(), "pass1");
	}

}

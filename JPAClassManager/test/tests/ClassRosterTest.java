package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.ClassRoster;

public class ClassRosterTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	ClassRoster cr;

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
	public void ClassRoster_Connected_To_DB() {
		cr = em.find(ClassRoster.class, 1);
		assertEquals(cr.getName(), "Spanish");
	}

	@Test
	public void test_CR_To_ClassSchedule() {
		cr = em.find(ClassRoster.class, 1);
		assertEquals(cr.getClassSchedules().get(0).getId(), 1);
		assertNotNull(cr.getClassSchedules());
		assertEquals(cr.getClassSchedules().get(0).getWeekDay().getName(), "Monday");
	}

	@Test
	public void test_CR_To_Student() {
		cr = em.find(ClassRoster.class, 1);
		assertEquals(cr.getStudents().get(0).getFirstName(), "Lil Bobbie");
		assertNotNull(cr.getStudents());
		assertEquals(cr.getStudents().get(0).getRoles().get(0).getName(), "Hall Monitor");
	}

	@Test
	public void test_CR_To_Teacher() {
		cr = em.find(ClassRoster.class, 1);
		assertEquals(cr.getTeacher().getFirstName(), "Annie");
		assertNotNull(cr.getTeacher().getClasses());
		assertEquals(cr.getTeacher().getClasses().get(0).getName(), "Spanish");
	}

	@Test
	public void test_CR_To_WeekDay() {
		cr = em.find(ClassRoster.class, 1);
		assertEquals(cr.getWeekDays().get(0).getName(), "Monday");
		assertNotNull(cr.getWeekDays());
	}
}

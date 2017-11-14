package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.ClassSchedule;

public class ClassScheduleTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	ClassSchedule cs;

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
		cs = em.find(ClassSchedule.class, 1);
		assertEquals(cs.getClassRoster().getName(), "Spanish");
		assertEquals(cs.getWeekDay().getName(), "Monday");
	}

//	@Test
//	public void test_CR_To_ClassSchedule() {
//		cs = em.find(ClassSchedule.class, 1);
//		assertEquals(cr.getClassSchedules().get(0).getId(), 1);
//		assertNotNull(cr.getClassSchedules());
//		assertEquals(cr.getClassSchedules().get(0).getWeekDay().getName(), "Monday");
//	}
//
//	@Test
//	public void test_CR_To_Student() {
//		cs = em.find(ClassSchedule.class, 1);
//		assertEquals(cr.getStudents().get(0).getFirstName(), "Lil Bobbie");
//		assertNotNull(cr.getStudents());
//		assertEquals(cr.getStudents().get(0).getRoles().get(0).getName(), "Hall Monitor");
//	}
//
//	@Test
//	public void test_CR_To_Teacher() {
//		cs = em.find(ClassSchedule.class, 1);
//		assertEquals(cr.getTeacher().getFirstName(), "Annie");
//		assertNotNull(cr.getTeacher().getClasses());
//		assertEquals(cr.getTeacher().getClasses().get(0).getName(), "Spanish");
//	}

}

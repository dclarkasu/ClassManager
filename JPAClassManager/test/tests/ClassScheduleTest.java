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

}

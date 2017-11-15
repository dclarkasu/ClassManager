package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.WeekDay;

public class WeekDayTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	WeekDay wd;

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
	public void WeekDay_Connected_To_DB() {
		wd = em.find(WeekDay.class, 1);
		assertEquals(wd.getName(), "Monday");
		assertEquals(wd.getStartTime(), "8am");
		assertEquals(wd.getEndTime(), "9am");
	}

	@Test
	public void test_WD_To_ClassRoster() {
		wd = em.find(WeekDay.class, 1);
		assertEquals(wd.getClasses().get(0).getName(), "Spanish");
		assertEquals(wd.getClasses().get(0).getTeacher().getFirstName(), "Annie");
		assertNotNull(wd.getClasses());
	}

	@Test
	public void test_WD_To_ClassSchedule() {
		wd = em.find(WeekDay.class, 1);
		assertEquals(wd.getClassSchedules().get(0).getClassRoster().getName(), "Spanish");
		assertNotNull(wd.getClassSchedules());
		assertEquals(wd.getClassSchedules().get(0).getWeekDay().getName(), "Monday");
	}

}

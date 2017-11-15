package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Grade;

public class GradeTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Grade grade;

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
	public void Grade_Connected_To_DB() {
		grade = em.find(Grade.class, 1);
		assertEquals(grade.getLevel(), 1);
	}

	@Test
	public void test_Grade_To_Student() {
		grade = em.find(Grade.class, 6);
		assertEquals(grade.getStudents().get(0).getFirstName(), "Lil Bobbie");
		assertEquals(grade.getStudents().get(0).getRoles().get(0).getName(), "Hall Monitor");
		assertNotNull(grade.getStudents());
	}

}

package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Role;

public class RoleTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Role role;

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
	public void Role_Connected_To_DB() {
		role = em.find(Role.class, 1);
		assertEquals(role.getName(), "Hall Monitor");
		assertEquals(role.getDescription(), "Walk it like you own it");
	}

	@Test
	public void Role_To_Student() {
		role = em.find(Role.class, 1);
		assertEquals(role.getStudents().get(0).getFirstName(), "Lil Bobbie");
		assertEquals(role.getStudents().get(0).getClassRoster().getName(), "Spanish");
		assertEquals(role.getStudents().get(0).getGrade().getLevel(), 6);
		assertNotNull(role.getStudentRoles());
	}

}

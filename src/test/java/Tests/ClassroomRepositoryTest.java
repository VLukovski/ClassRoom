package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomRepositoryTest {

	private static final String MOCK_ARRAY1 = "[{\"trainer\":\"Matt\",\"trainees\":[]},{\"trainer\":\"Jordan\",\"trainees\":[]}]";

	private static final String MOCK_ARRAY2 = "[{\"trainer\":\"Matt\",\"trainees\":[]}]";

	private static final String MOCK_OBJECT = "{\"trainer\":\"Matt\",\"trainees\":[]}";

	@InjectMocks
	private ClassroomDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private List<Classroom> classrooms;

	@Before
	public void setup() {
		classrooms = new ArrayList<Classroom>();
		classrooms.add(new Classroom("Matt"));
		classrooms.add(new Classroom("Jordan"));
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllClassrooms() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(classrooms);
		assertEquals(MOCK_ARRAY1, repo.getAllClassrooms());
	}

	@Test
	public void testGetAClassroom() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(classrooms.get(0));
		assertEquals(MOCK_OBJECT, repo.getAClassroom(1L));
	}

	@Test
	public void testCreateClassroom() {
		String reply = repo.createClassroom(MOCK_OBJECT);
		assertEquals("{\"message\": \"classroom has been sucessfully added\"}", reply);
	}

	@Test
	public void testDeleteClassroomPass() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		String reply = repo.deleteClassroom(1L);
		assertEquals("{\"message\": \"classroom has been sucessfully deleted\"}", reply);
	}

	@Test
	public void testDeleteClassroomFail() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(false);
		String reply = repo.deleteClassroom(0L);
		assertEquals("{\"message\": \"this classroom does not exist\"}", reply);
	}

	@Test
	public void testUpdateClassroomFail() {
		String update = "{\"trainer\":\"Jordan\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(false);
		assertEquals("{\"message\": \"this classroom does not exist\"}", repo.updateClassroom(1L, update));
	}

	@Test
	public void testUpdateClassroomPass() {
		String update = "{\"trainer\":\"Jordan\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(classrooms.get(0));
		assertEquals("{\"message\": \"classroom has been sucessfully updated\"}", repo.updateClassroom(1L, update));
	}
}

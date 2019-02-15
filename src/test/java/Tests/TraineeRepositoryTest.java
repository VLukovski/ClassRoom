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

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeRepositoryTest {

	private static final String MOCK_ARRAY1 = "[{\"traineeName\":\"Joe\",\"classroomId\":1},{\"traineeName\":\"Jane\",\"classroomId\":2}]";

	private static final String MOCK_ARRAY2 = "[{\"traineeName\":\"Joe\",\"classroomId\":1}]";

	private static final String MOCK_OBJECT = "{\"traineeName\":\"Joe\",\"classroomId\":1}";

	@InjectMocks
	private TraineeDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	List<Trainee> trainees;

	@Before
	public void setup() {
		trainees = new ArrayList<Trainee>();
		trainees.add(new Trainee("Joe", 1L));
		trainees.add(new Trainee("Jane", 2L));
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllTrainees() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(trainees);
		assertEquals(MOCK_ARRAY1, repo.getAllTrainees());
	}

	@Test
	public void testGetATrainee() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(trainees.get(0));
		assertEquals(MOCK_OBJECT, repo.getATrainee(1L));
	}

	@Test
	public void testCreateTrainee() {
		String reply = repo.createTrainee(MOCK_OBJECT);
		assertEquals("{\"message\": \"trainee has been sucessfully added\"}", reply);
	}

	@Test
	public void testDeleteTraineePass() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		String reply = repo.deleteTrainee(1L);
		assertEquals("{\"message\": \"trainee has been sucessfully deleted\"}", reply);
	}

	@Test
	public void testDeleteTraineeFail() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(false);
		String reply = repo.deleteTrainee(0L);
		assertEquals("{\"message\": \"this trainee does not exist\"}", reply);
	}

	@Test
	public void testUpdateTraineeFail() {
		String update = "{\"trainer\":\"Jordan\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(false);
		assertEquals("{\"message\": \"this trainee does not exist\"}", repo.updateTrainee(1L, update));
	}

	@Test
	public void testUpdateTraineePass() {
		String update = "{\"trainer\":\"Jordan\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(trainees.get(0));
		assertEquals("{\"message\": \"trainee has been sucessfully updated\"}", repo.updateTrainee(1L, update));
	}
}

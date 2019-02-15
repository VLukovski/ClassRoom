package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.TraineeServiceImpl;
import com.qa.persistence.repository.TraineeRepository;

@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceTest {

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private TraineeServiceImpl service;

	@Mock
	private TraineeRepository repo;

	@Before
	public void setup() {
		service.setRepository(repo);
	}

	@Test
	public void test1() {
		Mockito.when(repo.getAllTrainees()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllTrainees());
	}

	@Test
	public void test2() {
		Mockito.when(repo.getATrainee(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getATrainee(Mockito.anyLong()));
	}

	@Test
	public void test3() {
		Mockito.when(repo.createTrainee(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.createTrainee(Mockito.anyString()));
	}

	@Test
	public void test4() {
		Mockito.when(repo.updateTrainee(Mockito.anyLong(), Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateTrainee(Mockito.anyLong(), Mockito.anyString()));
	}

	@Test
	public void test5() {
		Mockito.when(repo.deleteTrainee(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteTrainee(Mockito.anyLong()));
	}
}

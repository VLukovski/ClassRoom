package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.TraineeService;
import com.qa.rest.TraineeEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class TraineeEndpointTest {

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private TraineeEndpoint endpoint;

	@Mock
	private TraineeService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void test1() {
		Mockito.when(service.getAllTrainees()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAllTrainees());
	}

	@Test
	public void test2() {
		Mockito.when(service.getATrainee(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getATrainee(Mockito.anyLong()));
	}

	@Test
	public void test3() {
		Mockito.when(service.createTrainee(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.createTrainee(Mockito.anyString()));
	}

	@Test
	public void test4() {
		Mockito.when(service.updateTrainee(Mockito.anyLong(), Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateTrainee(Mockito.anyLong(), Mockito.anyString()));
	}

	@Test
	public void test5() {
		Mockito.when(service.deleteTrainee(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteTrainee(Mockito.anyLong()));
	}
}
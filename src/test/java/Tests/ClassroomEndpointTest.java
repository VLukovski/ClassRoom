package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.ClassroomService;
import com.qa.rest.ClassroomEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomEndpointTest {

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private ClassroomEndpoint endpoint;

	@Mock
	private ClassroomService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void test1() {
		Mockito.when(service.getAllClassrooms()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAllClassrooms());
	}

	@Test
	public void test2() {
		Mockito.when(service.getAClassroom(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAClassroom(Mockito.anyLong()));
	}

	@Test
	public void test3() {
		Mockito.when(service.createClassroom(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.createClassroom(Mockito.anyString()));
	}

	@Test
	public void test4() {
		Mockito.when(service.updateClassroom(Mockito.anyLong(), Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateClassroom(Mockito.anyLong(), Mockito.anyString()));
	}

	@Test
	public void test5() {
		Mockito.when(service.deleteClassroom(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteClassroom(Mockito.anyLong()));
	}
}

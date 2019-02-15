package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.ClassroomServiceImpl;
import com.qa.persistence.repository.ClassroomRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomServiceTest {

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private ClassroomServiceImpl service;

	@Mock
	private ClassroomRepository repo;

	@Before
	public void setup() {
		service.setRepository(repo);
	}

	@Test
	public void test1() {
		Mockito.when(repo.getAllClassrooms()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllClassrooms());
	}

	@Test
	public void test2() {
		Mockito.when(repo.getAClassroom(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAClassroom(Mockito.anyLong()));
	}

	@Test
	public void test3() {
		Mockito.when(repo.createClassroom(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.createClassroom(Mockito.anyString()));
	}

	@Test
	public void test4() {
		Mockito.when(repo.updateClassroom(Mockito.anyLong(), Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateClassroom(Mockito.anyLong(), Mockito.anyString()));
	}

	@Test
	public void test5() {
		Mockito.when(repo.deleteClassroom(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteClassroom(Mockito.anyLong()));
	}
}

package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ ClassroomEndpointTest.class, TraineeEndpointTest.class, ClassroomServiceTest.class,
		TraineeServiceTest.class, ClassroomRepositoryTest.class, TraineeRepositoryTest.class })

public class TestSuite {
}
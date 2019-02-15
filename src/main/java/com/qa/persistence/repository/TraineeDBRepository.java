package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllTrainees() {
		return util
				.getJsonForObject((Collection<Trainee>) manager.createQuery("SELECT t FROM Trainee t").getResultList());
	}

	@Override
	public String getATrainee(Long id) {
		return util.getJsonForObject(manager.find(Trainee.class, id));
	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJson(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		if (manager.contains(manager.find(Trainee.class, id))) {
			manager.remove(manager.find(Trainee.class, id));
			return "{\"message\": \"trainee has been sucessfully deleted\"}";
		}
		return "{\"message\": \"this trainee does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String trainee) {
		Trainee aTrainee = util.getObjectForJson(trainee, Trainee.class);
		if (manager.contains(manager.find(Trainee.class, id))) {
			if (aTrainee.getTraineeName() != null) {
				manager.find(Trainee.class, id).setTraineeName(aTrainee.getTraineeName());
			}
			if (aTrainee.getClassroomId() != null) {
				manager.find(Trainee.class, id).setClassroomId(aTrainee.getClassroomId());
			}
			return "{\"message\": \"trainee has been sucessfully updated\"}";
		}
		return "{\"message\": \"this trainee does not exist\"}";
	}

}
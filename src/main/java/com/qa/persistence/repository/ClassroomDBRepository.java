package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllClassrooms() {
		return util.getJsonForObject((Collection<Classroom>) manager.createQuery("SELECT c FROM Classroom c").getResultList());
	}

	@Override
	public String getAClassroom(Long id) {
		return util.getJsonForObject(manager.find(Classroom.class, id));
	}

	@Override
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJson(classroom, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		if (manager.contains(manager.find(Classroom.class, id))) {
			manager.remove(manager.find(Classroom.class, id));
			return "{\"message\": \"classroom has been sucessfully deleted\"}";
		}
		return "{\"message\": \"this classroom does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateClassroom(Long id, String classroom) {
		Classroom aClassroom = util.getObjectForJson(classroom, Classroom.class);
		if (manager.contains(manager.find(Classroom.class, id))) {
			manager.find(Classroom.class, id).setTrainer(aClassroom.getTrainer());
			return "{\"message\": \"classroom has been sucessfully updated\"}";
		}
		return "{\"message\": \"this classroom does not exist\"}";
	}
	
}

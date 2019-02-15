package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImpl implements ClassroomService {
	
	@Inject
	private ClassroomRepository repo;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	@Override
	public String getAClassroom(Long id) {
		return repo.getAClassroom(id);
	}

	@Override
	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);
	}

	@Override
	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

	@Override
	public String updateClassroom(Long id, String classroom) {
		return repo.updateClassroom(id, classroom);
	}

}

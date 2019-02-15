package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository repo;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	@Override
	public String getATrainee(Long id) {
		return repo.getATrainee(id);
	}

	@Override
	public String createTrainee(String classroom) {
		return repo.createTrainee(classroom);
	}

	@Override
	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}

	@Override
	public String updateTrainee(Long id, String classroom) {
		return repo.updateTrainee(id, classroom);
	}

	@Override
	public void setRepository(TraineeRepository repo) {
		this.repo = repo;
	}
}

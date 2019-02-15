package com.qa.business.service;

import com.qa.persistence.repository.TraineeRepository;

public interface TraineeService {

	String getAllTrainees();

	String getATrainee(Long id);

	String createTrainee(String trainee);

	String deleteTrainee(Long id);

	String updateTrainee(Long id, String trainee);

	void setRepository(TraineeRepository repo);

}

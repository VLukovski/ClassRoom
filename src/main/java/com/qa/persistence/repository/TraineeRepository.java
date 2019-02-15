package com.qa.persistence.repository;

import javax.persistence.EntityManager;

import com.qa.util.JSONUtil;

public interface TraineeRepository {

	String getAllTrainees();

	String getATrainee(Long id);

	String createTrainee(String trainee);

	String deleteTrainee(Long id);

	String updateTrainee(Long id, String trainee);

	void setUtil(JSONUtil util);

	void setManager(EntityManager manager);

}

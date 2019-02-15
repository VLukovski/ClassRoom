package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.transaction.Transactional;

@Transactional(SUPPORTS)
public class TraineeDBRepository implements TraineeRepository {

	public String getAllTrainees() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getATrainee() {
		// TODO Auto-generated method stub
		return null;
	}

	public String createTrainee() {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteTrainee() {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateTrainee() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

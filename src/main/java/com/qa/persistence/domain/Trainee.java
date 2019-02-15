package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	public Trainee() {
	}

	public Trainee(String traineeName) {
		super();
		this.traineeName = traineeName;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long traineeId;

	private String traineeName;

	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

}

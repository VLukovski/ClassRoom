package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.transaction.Transactional;

@Transactional(SUPPORTS)
public class ClassroomDBRepository implements ClassroomRepository {

	public String getAllClassrooms() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAClassroom() {
		// TODO Auto-generated method stub
		return null;
	}

	public String createClassroom() {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteClassroom() {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateClassroom() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

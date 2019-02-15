package com.qa.persistence.repository;

import javax.persistence.EntityManager;

import com.qa.util.JSONUtil;

public interface ClassroomRepository {
	
	String getAllClassrooms();
	
	String getAClassroom(Long id);
	
	String createClassroom(String classroom);
	
	String deleteClassroom(Long id);
	
	String updateClassroom(Long id, String classroom);

	void setUtil(JSONUtil util);

	void setManager(EntityManager manager);

}

package com.qa.business.service;

import com.qa.persistence.repository.ClassroomRepository;

public interface ClassroomService {
	
	String getAllClassrooms();
	
	String getAClassroom(Long id);
	
	String createClassroom(String classroom);
	
	String deleteClassroom(Long id);
	
	String updateClassroom(Long id, String classroom);
	
	void setRepository(ClassroomRepository repo);

}

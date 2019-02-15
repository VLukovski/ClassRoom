package com.qa.persistence.repository;

public interface ClassroomRepository {
	
	String getAllClassrooms();
	
	String getAClassroom(Long id);
	
	String createClassroom(String classroom);
	
	String deleteClassroom(Long id);
	
	String updateClassroom(Long id, String classroom);
	
}

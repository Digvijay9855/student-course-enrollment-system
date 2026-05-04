package service;

import java.util.List;

import model.Instructor;

public interface I_InstructorService {
	void addInstructor(Instructor instructor);
    List<Instructor> viewInstructors();
    void updateInstructor(int id, Instructor instructor);
    void deleteInstructor(int id);
    
}	

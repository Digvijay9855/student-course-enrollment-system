package service;

import java.util.ArrayList;
import java.util.List;

import model.Instructor;

public class InstructorServiceImpl implements I_InstructorService {
	 private List<Instructor> instructors = new ArrayList<>();

	    @Override
	    public void addInstructor(Instructor instructor) {
	        instructors.add(instructor);
	        System.out.println("Instructor added: " + instructor);
	    }

	    @Override
	    public List<Instructor> viewInstructors() {
	        return instructors;
	    }

	    @Override
	    public void updateInstructor(int id, Instructor updatedInstructor) {
	        for (Instructor instructor : instructors) {
	            if (instructor.getId() == id) {
	                instructor.setName(updatedInstructor.getName());
	                System.out.println("Instructor updated: " + instructor);
	                return;
	            }
	        }
	        System.out.println("Instructor with ID " + id + " not found.");
	    }

	    @Override
	    public void deleteInstructor(int id) {
	        instructors.removeIf(instructor -> instructor.getId() == id);
	        System.out.println("Instructor with ID " + id + " deleted.");
	    }
}

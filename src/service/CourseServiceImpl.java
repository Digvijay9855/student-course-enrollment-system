package service;

import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseServiceImpl implements I_CourseService {
	 private List<Course> courses = new ArrayList<>();

	    @Override
	    public void addCourse(Course course) {
	        courses.add(course);
	        System.out.println("Course added: " + course);
	    }

	    @Override
	    public List<Course> viewCourses() {
	        return courses;
	    }

	    @Override
	    public void updateCourse(int id, Course updatedCourse) {
	        for (Course course : courses) {
	            if (course.getId() == id) {
	                course.setName(updatedCourse.getName());
	                course.setInstructor(updatedCourse.getInstructor());
	                System.out.println("Course updated: " + course);
	                return;
	            }
	        }
	        System.out.println("Course with ID " + id + " not found.");
	    }

	    @Override
	    public void deleteCourse(int id) {
	        courses.removeIf(course -> course.getId() == id);
	        System.out.println("Course with ID " + id + " deleted.");
	    }
}

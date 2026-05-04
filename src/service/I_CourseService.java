package service;

import java.util.List;

import model.Course;

public interface I_CourseService {
	  void addCourse(Course course);
	    List<Course> viewCourses();
	    void updateCourse(int id, Course course);
	    void deleteCourse(int id);
}

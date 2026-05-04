package service;

import java.util.List;

import model.Enrollment;

public interface I_EnrollmentService {
	  void enrollStudent(Enrollment enrollment);
	    List<Enrollment> viewEnrollments();
	    void unenrollStudent(int studentId, int courseId);
}

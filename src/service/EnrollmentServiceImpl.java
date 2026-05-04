package service;

import java.util.ArrayList;
import java.util.List;

import model.Enrollment;

public class EnrollmentServiceImpl implements I_EnrollmentService {
	private List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public void enrollStudent(Enrollment enrollment) {
        enrollments.add(enrollment);
        System.out.println("Student enrolled: " + enrollment);
    }

    @Override
    public List<Enrollment> viewEnrollments() {
        return enrollments;
    }

    @Override
    public void unenrollStudent(int studentId, int courseId) {
        enrollments.removeIf(enrollment -> enrollment.getStudent().getId() == studentId && enrollment.getCourse().getId() == courseId);
        System.out.println("Student with ID " + studentId + " unenrolled from Course ID " + courseId);
    }
}

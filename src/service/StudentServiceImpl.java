package service;

import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentServiceImpl implements I_StudentService {

	
	private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student);
    }

    @Override
    public List<Student> viewStudents() {
        return students;
    }

    @Override
    public void updateStudent(int id, Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                System.out.println("Student updated: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    @Override
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        System.out.println("Student with ID " + id + " deleted.");
    }
}

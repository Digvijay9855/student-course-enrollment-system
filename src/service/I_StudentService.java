package service;

import java.util.List;

import model.Student;

public interface I_StudentService {
	void addStudent(Student student);
    List<Student> viewStudents();
    void updateStudent(int id, Student student);
    void deleteStudent(int id);
}

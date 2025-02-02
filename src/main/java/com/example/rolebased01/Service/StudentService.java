package com.example.rolebased01.Service;

import com.example.rolebased01.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getStudents() throws Exception;
    Student getStudent(long id) throws Exception;
    Student addStudent(Student student) throws Exception;
    Student updateStudent(Student student) throws Exception;
    void deleteStudent(long id) throws Exception;
    Student registerStudent(Student student) throws Exception;
}

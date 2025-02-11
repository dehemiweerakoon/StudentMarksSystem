package com.example.rolebased01.Service;

import com.example.rolebased01.Entity.Role;
import com.example.rolebased01.Entity.Student;
import com.example.rolebased01.Entity.User;
import com.example.rolebased01.Repository.StudentRepository;
import com.example.rolebased01.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Student> getStudents() throws Exception {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(long id) throws Exception {
        return studentRepository.findById(id).orElse(null);
    }


    @Override
    public Student addStudent(Student student) throws Exception {
        // then for creation of the student admin should create a user account for the student ....
        // creation of the password that default
        User user = new User();

        user.setUsername(student.getFirstName());
        user.setEmail(student.getLastName()+student.getFirstName()+"stu.kln.ac.lk");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(2,"ROLE_USER"));
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(student.getLastName().toLowerCase()+"123")); /// warn student that their initial password is "lastname"+123


        userRepository.save(user);

        Long id = user.getId();
        System.out.println(id);
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) throws Exception {
        Student student1 = getStudent(student.getId());
        student1.setFirstName(student.getFirstName());
        student1.setYear(student.getYear());
        student1.setLastName(student.getLastName());
        return studentRepository.save(student1);
    }


    @Override
    public void deleteStudent(long id) throws Exception {
       studentRepository.deleteById(id);
    }

    @Override
    public Student registerStudent(Student student) throws Exception {
        return studentRepository.save(student);
    }
}

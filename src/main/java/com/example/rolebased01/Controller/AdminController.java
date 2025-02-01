package com.example.rolebased01.Controller;

import com.example.rolebased01.Entity.Course;
import com.example.rolebased01.Entity.Student;
import com.example.rolebased01.Service.CourseService;
import com.example.rolebased01.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;


   @GetMapping("/students")
    public ResponseEntity<?> getStudents() throws Exception {
         return  ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
   }
   @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody Student student) throws Exception {
       try{
           return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
       }catch (SQLException ex){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
       }catch (Exception ex){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
       }
   }
   @PostMapping("/course")
    public ResponseEntity<?> createCourse(@RequestBody Course course) throws Exception {
       try{
           return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(course));
       }catch (SQLException ex){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
       }catch (Exception ex){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
       }
   }

}

package com.example.rolebased01.Controller;

import com.example.rolebased01.Entity.Course;
import com.example.rolebased01.Entity.CourseMarking;
import com.example.rolebased01.Entity.Student;
import com.example.rolebased01.Service.CourseMarkingService;
import com.example.rolebased01.Service.CourseService;
import com.example.rolebased01.Service.StudentService;
import com.example.rolebased01.payloads.AddMarks;
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

    @Autowired
    private CourseMarkingService courseMarkingService;


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
   @PostMapping("/marks")
    public ResponseEntity<?> addStudent(@RequestBody AddMarks addMarks) throws Exception {
       try{
           Student student = studentService.getStudent(addMarks.getStudentId());
           Course course = courseService.getCourse(addMarks.getCourseId());
           System.out.println(addMarks.getMarks());
           CourseMarking courseMarking= courseMarkingService.saveCourseMarking(new CourseMarking(student,course,addMarks.getMarks()));

           if (courseMarking != null) {
               return ResponseEntity.status(HttpStatus.CREATED).body(courseMarking);
           }else{
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Course marking not created");
           }
       }catch (SQLException ex){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
       }catch (Exception ex){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
       }

   }
   @PutMapping("/marks")
    public ResponseEntity<?> updateMarks(@RequestBody AddMarks addMarks) throws Exception {
       try{
           Student student = studentService.getStudent(addMarks.getStudentId());
           Course course = courseService.getCourse(addMarks.getCourseId());
           CourseMarking courseMarking =courseMarkingService.saveCourseMarking(new CourseMarking(student,course,addMarks.getMarks()));
           return  ResponseEntity.status(HttpStatus.OK).body(courseMarking);
       }catch (SQLException ex){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
       }
       catch (Exception ex){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
       }
   }

}

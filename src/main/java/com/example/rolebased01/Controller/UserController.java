package com.example.rolebased01.Controller;

import com.example.rolebased01.Entity.CourseMarking;
import com.example.rolebased01.Service.CourseMarkingService;
import com.example.rolebased01.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// added
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseMarkingService courseMarkingService;


    @GetMapping("/marks/{id}")
    public ResponseEntity<List<CourseMarking>> getMarks(@PathVariable long id) throws Exception {

            List<CourseMarking> courseMarking = courseMarkingService.getByStudentId(id);
            return ResponseEntity.status(HttpStatus.OK).body(courseMarking);

    }
    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id) {
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

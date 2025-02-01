package com.example.rolebased01.Controller;

import com.example.rolebased01.Entity.CourseMarking;
import com.example.rolebased01.Service.CourseMarkingService;
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
    private CourseMarkingService courseMarkingService;


    @GetMapping("/marks/{id}")
    public ResponseEntity<?> getMarks(@PathVariable long id) {
        try{
            List<CourseMarking> courseMarking = courseMarkingService.getByStudentId(id);
            return ResponseEntity.status(HttpStatus.OK).body(courseMarking);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

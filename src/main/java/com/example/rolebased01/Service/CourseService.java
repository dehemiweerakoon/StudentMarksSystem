package com.example.rolebased01.Service;

import com.example.rolebased01.Entity.Course;;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<Course> getCourses() throws Exception;
    Course getCourse(long id) throws Exception;
    Course addCourse(Course course) throws Exception;
    Course updateCourse(Course course) throws Exception;
    void deleteCourse(long id) throws Exception;
}

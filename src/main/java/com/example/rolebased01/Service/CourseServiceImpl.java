package com.example.rolebased01.Service;

import com.example.rolebased01.Entity.Course;
import com.example.rolebased01.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() throws Exception {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(long id) throws Exception {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course addCourse(Course course) throws Exception {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) throws Exception {
        Course oldCourse = getCourse(course.getId());
        oldCourse.setCourseName(course.getCourseName());
        return courseRepository.save(oldCourse);
    }

    @Override
    public void deleteCourse(long id) throws Exception {
        courseRepository.deleteById(id);
    }
}

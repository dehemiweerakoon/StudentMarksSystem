package com.example.rolebased01.Service;

import com.example.rolebased01.Entity.CourseMarking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseMarkingService {

    public List<CourseMarking> getAllCourseMarking() throws Exception;
    public CourseMarking getCourseMarking(Integer id) throws Exception;
    public CourseMarking saveCourseMarking(CourseMarking courseMarking) throws Exception;
    public void deleteCourseMarking(Integer id) throws Exception;
    public CourseMarking updateCourseMarking(CourseMarking courseMarking) throws Exception;
}

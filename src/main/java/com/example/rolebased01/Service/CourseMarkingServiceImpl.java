package com.example.rolebased01.Service;

import com.example.rolebased01.Entity.CourseMarking;
import com.example.rolebased01.Repository.CourseMarkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMarkingServiceImpl implements CourseMarkingService {

    @Autowired
    private CourseMarkingRepository courseMarkingRepository;

    @Override
    public List<CourseMarking> getAllCourseMarking() throws Exception {
        return courseMarkingRepository.findAll();
    }

    @Override
    public CourseMarking getCourseMarking(Integer id) throws Exception {
        return courseMarkingRepository.findById(id).orElse(null);
    }

    @Override
    public CourseMarking saveCourseMarking(CourseMarking courseMarking) throws Exception {
        return courseMarkingRepository.save(courseMarking);
    }

    @Override
    public void deleteCourseMarking(Integer id) throws Exception {
        courseMarkingRepository.deleteById(id);
    }

    @Override
    public CourseMarking updateCourseMarking(CourseMarking courseMarking) throws Exception {
        CourseMarking updatedCourseMarking = getCourseMarking((int) courseMarking.getCourse().getId());
        updatedCourseMarking.setMarking(courseMarking.getMarking());
        return courseMarkingRepository.save(updatedCourseMarking);
    }
}

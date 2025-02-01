package com.example.rolebased01.Repository;

import com.example.rolebased01.Entity.CourseMarking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMarkingRepository extends JpaRepository<CourseMarking, Integer> {

    List<CourseMarking> findByStudentId(long studentId);
}

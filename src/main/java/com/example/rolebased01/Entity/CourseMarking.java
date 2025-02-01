package com.example.rolebased01.Entity;

import jakarta.persistence.*;


@Entity
public class CourseMarking {
//    @EmbeddedId
//    CourseMarkKey id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
//    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
//    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    @Column
    int marking;
    public CourseMarking() {
    }
    public CourseMarking(Student student, Course course, int marking) {
        this.student = student;
        this.course = course;
        this.marking = marking;
    }
//    public CourseMarkKey getId() {
//        return id;
//    }
//    public void setId(CourseMarkKey id) {
//        this.id = id;
//    }

    public int getMarking(){
        return marking;
    }

    public void setMarking(int marking){
        this.marking = marking;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
}

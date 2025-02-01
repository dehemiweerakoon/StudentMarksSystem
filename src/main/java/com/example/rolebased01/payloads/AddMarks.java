package com.example.rolebased01.payloads;


public class AddMarks {

    private Long courseId; ;
    private Long studentId;
    private int marks;

    public AddMarks(Long courseId, Long studentId, int marks) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.marks = marks;
    }
    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }

}

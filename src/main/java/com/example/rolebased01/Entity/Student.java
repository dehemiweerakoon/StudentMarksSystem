package com.example.rolebased01.Entity;


import jakarta.persistence.*;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = false, nullable = false)
    private String firstName;

    @Column(unique = false, nullable = false)
    private String lastName;

    @Column(unique = false, nullable = false)
    private int year;

    public Student(long id, String firstName, String lastName, int year) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
    }
    public Student() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "student_courses",
//                   joinColumns = @JoinColumn(name = "student_id")
//                   ,inverseJoinColumns = @JoinColumn(name = "course_id"))
//    private Set<Course> courses = new HashSet<>();
//    @OneToMany
//    private Set<CourseMarking> marking = new HashSet<>();
}

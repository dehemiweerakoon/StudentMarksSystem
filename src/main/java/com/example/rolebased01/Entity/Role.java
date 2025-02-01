package com.example.rolebased01.Entity;


import jakarta.persistence.*;
import lombok.Data;
// technically in here we assume that student are basic users and the admin are the teachers who put the marks and the grading system
// for the students ... in here
// ROLE_ADMIN =>  teacher
// ROLE_USER  => student (basic viewer) who can only see the marks and cannot do alter and edit marks
@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String name;
    // getter and setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role() {}
}


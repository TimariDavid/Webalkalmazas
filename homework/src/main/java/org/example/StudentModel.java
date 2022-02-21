package org.example;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public StudentModel() {
    }

    public StudentModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "name = " + name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

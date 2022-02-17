package org.example;

import java.util.ArrayList;

public class School {
    ArrayList<String> students;

    public School() {
        this.students = new ArrayList<>();
    }

    public void newStudent(String name) {
        this.students.add(name);
    }

    @Override
    public String toString() {
        StringBuilder stBuilder = new StringBuilder();

        for(String st : students) {
            stBuilder.append(st + " ");
        }
        return stBuilder.toString();
    }
}
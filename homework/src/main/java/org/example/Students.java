package org.example;

import java.util.ArrayList;

public class Students {
    ArrayList<String> students;

    public Students() {
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

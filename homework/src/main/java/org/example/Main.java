package org.example;

public class Main {

    public static void main(String[] args) {
        Students school = new Students();

        school.newStudent("Valaki1");
        school.newStudent("Valaki2");
        school.newStudent("Valaki3");

        System.out.println(school.toString());
    }

}

package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("org.example");

        School sc = ac.getBean(School.class);

        sc.newStudent("Valaki1");
        sc.newStudent("Valaki2");
        sc.newStudent("Valaki3");

        System.out.println(sc);
    }

}

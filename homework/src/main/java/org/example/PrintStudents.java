package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintStudents {

    private final FetchDataService fetchDataService;

    @Autowired
    public PrintStudents(FetchDataService fetchDataService) {
        this.fetchDataService = fetchDataService;
    }

    public void printStds() {
        fetchDataService.findAll().forEach(System.out::println);
    }
}

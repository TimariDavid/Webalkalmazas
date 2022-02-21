package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    FetchDataService fetchDataService;

    @GetMapping(path = "web")
    List<StudentModel> getStudents() {
        return fetchDataService.findAll();
    }
}

package org.example.aws.demo.service;

import org.example.aws.demo.pojo.Student;
import org.springframework.web.bind.annotation.*;

@RestController
public class AwsEcsEcrRestController {

    @RequestMapping("/")
    public String home() {
        return "Hello World first application!";
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody String studentName) {
        Student student = new Student(studentName);
        return student;
    }

    @RequestMapping(value = "/seyHello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World first application sayHello executed!";
    }


}

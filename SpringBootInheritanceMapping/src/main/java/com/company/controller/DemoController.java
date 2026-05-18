package com.company.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.StudentDTO;
import com.company.entity.Student;
import com.company.entity.base.Address;
import com.company.repo.PersonRepo;
import com.company.service.StudentService;
import com.company.dto.TeacherDTO;
import com.company.entity.Teacher;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final StudentService studentService;

    private final PersonRepo personRepo;

    public DemoController(StudentService studentService,
                          PersonRepo personRepo) {

        this.studentService = studentService;

        this.personRepo = personRepo;
    }

    @PostMapping("/add")
    public String add() {

        Student s1 = new Student(
                "Jiya",
                new Address("TK", "Jaipur", "30002")
        );

        s1.addEmail("abc@gmail.com");
        s1.addEmail("xyz@yahoo.com");

        Student s2 = new Student(
                "Tanu",
                new Address("Malviya", "South", "3545445")
        );

        s2.addEmail("tanu@gmail.com");
        s2.addEmail("tanu@yahoo.com");

        studentService.save(s1);

        studentService.save(s2);

        return "Record Added";
    }
    @PostMapping("/addteacher")
    public String addTeacher() {

        Teacher t1 = new Teacher(
                "Niti",
                new Address("JK", "Delhi", "110018"),
                "IT"
        );

        t1.addEmail("niti@gmail.com");
        t1.addEmail("niti@yahoo.com");

        Teacher t2 = new Teacher(
                "Riya",
                new Address("Park Street", "Kolkata", "700001"),
                "Spring Boot"
        );

        t2.addEmail("riya@gmail.com");
        t2.addEmail("riya@yahoo.com");

        studentService.saveTeacher(t1);

        studentService.saveTeacher(t2);

        return "Teachers Added";
    }
    @GetMapping("/teacherswithemail")
    public List<TeacherDTO> teachers() {

        return studentService.findAllTeachersWithEmails()
                .stream()
                .map(t -> new TeacherDTO(

                        t.getId(),

                        t.getName(),

                        t.getAddress().getCity(),

                        t.getSubject(),

                        t.getEmails()
                                .stream()
                                .map(e -> e.getEmail())
                                .toList()

                ))
                .collect(Collectors.toList());
    }
    @GetMapping("/studentswithemail")
    public List<StudentDTO> students() {

        return studentService.findAllWithEmails()
                .stream()
                .map(s -> new StudentDTO(

                        s.getId(),

                        s.getName(),

                        s.getAddress().getCity(),

                        s.getEmails()
                                .stream()
                                .map(e -> e.getEmail())
                                .toList()

                ))
                .collect(Collectors.toList());
    }
}
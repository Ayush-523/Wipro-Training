//package com.example.controller;
//
//import com.example.service.CourseService;
//import com.example.service.StudentService;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class DashboardController {
//
//    private final StudentService studentService;
//    private final CourseService courseService;
//
//    public DashboardController(StudentService studentService, CourseService courseService) {
//        this.studentService = studentService;
//        this.courseService = courseService;
//    }
//
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//
//    @GetMapping("/dashboard")
//    public String dashboard(Authentication authentication) {
//        String role = authentication.getAuthorities().iterator().next().getAuthority();
//        if (role.equals("ROLE_ADMIN")) {
//            return "redirect:/admin/dashboard";
//        }
//        return "redirect:/user/dashboard";
//    }
//
//    @GetMapping("/admin/dashboard")
//    public String adminDashboard(Model model) {
//        model.addAttribute("totalStudents", studentService.getAllStudents().size());
//        model.addAttribute("totalCourses", courseService.getAllCourses().size());
//        return "admin-dashboard";
//    }
//
//    @GetMapping("/user/dashboard")
//    public String userDashboard(Model model) {
//        model.addAttribute("courses", courseService.getAllCourses());
//        return "user-dashboard";
//    }
//}

package com.example.controller;

import com.example.service.CourseService;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final StudentService studentService;

    private final CourseService courseService;

    public DashboardController(
            StudentService studentService,
            CourseService courseService
    ) {

        this.studentService = studentService;

        this.courseService = courseService;
    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute(
                "totalStudents",
                studentService.getAllStudents().size()
        );

        model.addAttribute(
                "totalCourses",
                courseService.getAllCourses().size()
        );

        model.addAttribute(
                "courses",
                courseService.getAllCourses()
        );

        return "dashboard";
    }
}
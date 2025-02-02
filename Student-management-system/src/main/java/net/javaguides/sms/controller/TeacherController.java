package net.javaguides.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import net.javaguides.sms.entity.Teacher;
import net.javaguides.sms.service.TeacherService;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // Show login form
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "login";  // login.html
    }

    // Handle login
    @PostMapping("/login")
    public String login(@ModelAttribute("teacher") Teacher teacher, Model model) {
        Teacher loggedInTeacher = teacherService.findByUsername(teacher.getUsername());
        if (loggedInTeacher != null && teacherService.checkPassword(teacher.getPassword(), loggedInTeacher.getPassword())) {
            // Login successful
            model.addAttribute("teacher", loggedInTeacher);
            return "redirect:/students"; // Redirect to student management page
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; // Show login page again on failure
    }

    // Show registration form
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "register";  // register.html
    }

    // Handle registration
    @PostMapping("/register")
    public String register(@ModelAttribute("teacher") Teacher teacher, Model model) {
        // Save the teacher to the database
        teacherService.saveTeacher(teacher);
        model.addAttribute("success", "Teacher registered successfully!");
        return "redirect:/login"; // Redirect to login page after registration
    }
}
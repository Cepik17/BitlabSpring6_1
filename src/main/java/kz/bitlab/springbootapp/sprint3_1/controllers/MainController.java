package kz.bitlab.springbootapp.sprint3_1.controllers;

import kz.bitlab.springbootapp.sprint3_1.db.DBM;
import kz.bitlab.springbootapp.sprint3_1.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(Model model){
        List<Student> students = DBM.getStudents();
        model.addAttribute("students",students);
        return "main";
    }

    @GetMapping("/addstudent")
    public String addstudents(){
        return "addstudent";
    }


    @PostMapping("/addstudent")
    public String addStudent (@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam int exam){
        Student student = new Student();
        student.setName(name);
        student.setExam(exam);
        student.setSurname(surname);
        DBM.addStudent(student);
        student.setMark(exam);
        return "redirect:/";
    }
}

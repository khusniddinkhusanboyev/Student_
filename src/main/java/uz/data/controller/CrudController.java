package uz.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.data.services.StudentService;
import uz.data.model.Student;



@Controller
public class CrudController {
  private  StudentService studentService;
  @Autowired
    public CrudController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/details")
    public String getAll(Model model){

        model.addAttribute("data",studentService.getAll());
        return "student/student";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("student" ,new Student());
        return "student/form";
    }

    @PostMapping("/create")
    public String saveStudent(@ModelAttribute Student student,Model model)
    {


        studentService.create(student.getName(),student.getPhone(),student.getEmail(),student.getRegion(),student.getDistrict());
        model.addAttribute("st",student);
        return "student/form";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){

        studentService.delete(id);
        return "redirect:/details";
    }


    @GetMapping("/{id}/edit" )
    public String edit(Model model ,@PathVariable ("id") Long id){
        model.addAttribute( "oldInfo",studentService.find(id));
        return "student/update" ;
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("oldInfo") Student student, @PathVariable("id") Long id) {
        studentService.update(student.getName(),student.getEmail(),student.getPhone(),student.getRegion(),student.getDistrict(),id);
        return "redirect:/details";
    }

    @GetMapping("/details/{id}")
    public String show(@PathVariable("id") Long id , Model model){
      model.addAttribute("show",studentService.find(id));
        model.addAttribute("data",studentService.getAll());
      return "student/show";
    }
}

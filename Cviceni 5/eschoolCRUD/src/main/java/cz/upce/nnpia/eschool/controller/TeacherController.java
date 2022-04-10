package cz.upce.nnpia.eschool.controller;

import cz.upce.nnpia.eschool.dto.TeacherDto;
import cz.upce.nnpia.eschool.entity.Parent;
import cz.upce.nnpia.eschool.entity.Student;
import cz.upce.nnpia.eschool.entity.Teacher;
import cz.upce.nnpia.eschool.repository.ParentRepository;
import cz.upce.nnpia.eschool.repository.StudentRepository;
import cz.upce.nnpia.eschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @ExceptionHandler(RuntimeException.class)
    public String handleException(){
        return "error";
    }
    @GetMapping("/teacher-list")
    public String showAllTeachers(Model model){
        model.addAttribute("teacherList", teacherRepository.findAll());
        return "teacher-list";
    }
    @GetMapping(value = {"/teacher-form", "/teacher-form/{id}"})
    public String showTeacherForm(@PathVariable(required = false) Integer id, Model model){
        if(id != null){
            Teacher byId = teacherRepository.findById(id).orElse(new Teacher());
            TeacherDto dto = new TeacherDto();
            dto.setId(byId.getId());
            dto.setTeacherName(byId.getTeacherName());
            dto.setSpecialty(byId.getSpecialty());
            dto.setEmail(byId.getEmail());

            model.addAttribute("teacher", dto);
        }
        else {
            model.addAttribute("teacher", new TeacherDto());
        }
        return "teacher-form";
    }
    @PostMapping("/teacher-form-process")
    public String teacherFormProcess(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherDto.getTeacherName());
        teacher.setId(teacherDto.getId());
        teacher.setSpecialty(teacherDto.getSpecialty());
        teacher.setEmail(teacherDto.getEmail());

        teacherRepository.save(teacher);
        return "redirect:/teacher-list";
    }

    @GetMapping("/teacher-delete")
    public String deleteTeacher(@RequestParam Integer id){
        teacherRepository.deleteById(id);
        return "redirect:/teacher-list";
    }
}

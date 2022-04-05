package cz.upce.nnpia.eschool.controller;

import cz.upce.nnpia.eschool.entity.Parent;
import cz.upce.nnpia.eschool.entity.Student;
import cz.upce.nnpia.eschool.entity.Teacher;
import cz.upce.nnpia.eschool.repository.ParentRepository;
import cz.upce.nnpia.eschool.repository.StudentRepository;
import cz.upce.nnpia.eschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    @PostMapping
    Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }
}

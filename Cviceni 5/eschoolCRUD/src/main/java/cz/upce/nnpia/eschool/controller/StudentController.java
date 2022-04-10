package cz.upce.nnpia.eschool.controller;

import cz.upce.nnpia.eschool.entity.Parent;
import cz.upce.nnpia.eschool.entity.Student;
import cz.upce.nnpia.eschool.repository.ParentRepository;
import cz.upce.nnpia.eschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ParentRepository parentRepository;

    @GetMapping
    List<Student> getStudents(){
        return studentRepository.findAll();
    }
    @PostMapping
    Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
    @PutMapping("/{studentId}/parents/{parentId}")
    Student setParentToStudent(
            @PathVariable Integer studentId,
            @PathVariable Integer parentId
    ){
        Student student = studentRepository.findById(studentId).get();
        Parent parent = parentRepository.findById(parentId).get();
        student.setParent(parent);
        return studentRepository.save(student);
    }
}

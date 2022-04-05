package cz.upce.nnpia.eschool.controller;

import cz.upce.nnpia.eschool.entity.Parent;
import cz.upce.nnpia.eschool.entity.Student;
import cz.upce.nnpia.eschool.entity.Subject;
import cz.upce.nnpia.eschool.entity.Teacher;
import cz.upce.nnpia.eschool.repository.ParentRepository;
import cz.upce.nnpia.eschool.repository.StudentRepository;
import cz.upce.nnpia.eschool.repository.SubjectRepository;
import cz.upce.nnpia.eschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }
    @PostMapping
    Subject createSubject(@RequestBody Subject subject){
        return subjectRepository.save(subject);
    }
    @PutMapping("/{subjectId}/teachers/{teacherId}")
    Subject assignTeacherToSubject(
            @PathVariable Integer subjectId,
            @PathVariable Integer teacherId
    ){
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.assignTeacher(teacher);
        return subjectRepository.save(subject);
    }
    @PutMapping("/{subjectId}/students/{studentId}")
    Subject enrollStudentToSubject(
            @PathVariable Integer subjectId,
            @PathVariable Integer studentId
    ){
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }
}

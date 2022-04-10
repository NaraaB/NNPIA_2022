package cz.upce.nnpia.eschool.controller;

import cz.upce.nnpia.eschool.dto.SubjectDto;
import cz.upce.nnpia.eschool.entity.Parent;
import cz.upce.nnpia.eschool.entity.Student;
import cz.upce.nnpia.eschool.entity.Subject;
import cz.upce.nnpia.eschool.entity.Teacher;
import cz.upce.nnpia.eschool.repository.ParentRepository;
import cz.upce.nnpia.eschool.repository.StudentRepository;
import cz.upce.nnpia.eschool.repository.SubjectRepository;
import cz.upce.nnpia.eschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @ExceptionHandler(RuntimeException.class)
    public String handleException(){
        return "error";
    }
    @GetMapping("/subject-list")
    public String showAllSubjects(Model model){
        model.addAttribute("subjectList", subjectRepository.findAll());
        return "subject-list";
    }

    @GetMapping(value = {"/subject-form", "/subject-form/{id}"})
    public String showSubjectForm(@PathVariable(required = false) Integer id, Model model){
        if(id != null){
            Subject byId = subjectRepository.findById(id).orElse(new Subject());
            SubjectDto dto = new SubjectDto();
            dto.setId(byId.getId());
            dto.setSubjectName(byId.getSubjectName());
            dto.setDescription(byId.getDescription());
            dto.setTeacher(byId.getTeacher());

            model.addAttribute("subject", dto);
        }
        else {
            model.addAttribute("subject", new SubjectDto());
        }
        return "subject-form";
    }

    @PostMapping("subject-form-process")
    public String subjectFormProcess(SubjectDto subjectDto){
        Subject subject = new Subject();
        subject.setSubjectName(subjectDto.getSubjectName());
        subject.setId(subjectDto.getId());
        subject.setDescription(subjectDto.getDescription());
        //subject.assignTeacher(subjectDto.getTeacher());

        subjectRepository.save(subject);
        return "redirect:/subject-list";
    }

    @GetMapping("/subject-delete")
    public String deleteSubject(@RequestParam Integer id){
        subjectRepository.deleteById(id);
        return "redirect:/subject-list";
    }

    /*
    @PutMapping("/subjects/{subjectId}/teachers/{teacherId}")
    Subject assignTeacherToSubject(
            @PathVariable Integer subjectId,
            @PathVariable Integer teacherId
    ){
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.assignTeacher(teacher);
        return subjectRepository.save(subject);
    }
    @PutMapping("/subjects/{subjectId}/students/{studentId}")
    Subject enrollStudentToSubject(
            @PathVariable Integer subjectId,
            @PathVariable Integer studentId
    ){
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }
    */
}

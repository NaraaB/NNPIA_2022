package cz.upce.nnpia.eschool;

import cz.upce.nnpia.eschool.entity.Parent;
import cz.upce.nnpia.eschool.entity.Student;
import cz.upce.nnpia.eschool.entity.Subject;
import cz.upce.nnpia.eschool.entity.Teacher;
import cz.upce.nnpia.eschool.repository.ParentRepository;
import cz.upce.nnpia.eschool.repository.StudentRepository;
import cz.upce.nnpia.eschool.repository.SubjectRepository;
import cz.upce.nnpia.eschool.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class EschoolApplicationTests {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ParentRepository parentRepository;

    @Test
    void saveDataTest() {
        Student student1, student2, student3, student4, student5, student6;
        Parent parent1, parent2, parent3;
        Teacher teacher1,teacher2, teacher3;
        Subject subject1, subject2, subject3, subject4, subject5;

        student1 = new Student("st1","science",7);
        student2 = new Student("st2","language",2);
        student3 = new Student("st3","science",3);
        student4 = new Student("st4","arts",5);
        student5 = new Student("st5","science",5);
        student6 = new Student("st6","language",4);

        parent1 = new Parent("parent1");
        parent2 = new Parent("parent2");
        parent3 = new Parent("parent3");

        teacher1 = new Teacher("teacher1");
        teacher1.setSpecialty("science");
        teacher2 = new Teacher("teacher2");
        teacher2.setSpecialty("art");
        teacher3 = new Teacher("teacher3");
        teacher3.setSpecialty("language");

        subject1 = new Subject("mathematics");
        subject2 = new Subject("chemistry");
        subject3 = new Subject("english");
        subject4 = new Subject("physics");
        subject5 = new Subject("painting");

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);

        parentRepository.save(parent1);
        parentRepository.save(parent2);
        parentRepository.save(parent3);

        teacherRepository.save(teacher1);
        teacherRepository.save(teacher2);
        teacherRepository.save(teacher3);


        subjectRepository.save(subject1);
        subjectRepository.save(subject2);
        subjectRepository.save(subject3);
        subjectRepository.save(subject4);
        subjectRepository.save(subject5);

    }
    @Test
    void updateDataTest(){
        Student student = studentRepository.findById(1).get();
        Parent parent = parentRepository.findById(1).get();
        student.setParent(parent);
        studentRepository.save(student);

        Subject subject = subjectRepository.findById(1).get();
        Teacher teacher = teacherRepository.findById(1).get();
        subject.assignTeacher(teacher);
        //subject.enrollStudent(student);
        subjectRepository.save(subject);
    }
    @Test
    void enrollStudentToSubjectTest(){
        Subject subject = subjectRepository.findById(1).get();
        Student student = studentRepository.findById(1).get();
        subject.enrollStudent(student);
        subjectRepository.save(subject);
    }

    @Test
    void findDataTest(){
        List<Subject> contains = subjectRepository.findSubjectsBySubjectNameContains("em");
        List<Subject> subjectsByIdBetween = subjectRepository.findSubjectsByIdBetween(2,4);
    }
    @Test
    void sortDataTest(){
        List<Subject> sortAscByName = subjectRepository.findAll(Sort.by(Sort.Direction.ASC, "subjectName"));
        List<Subject> sortDescByName = subjectRepository.findAll(Sort.by(Sort.Direction.DESC, "subjectName"));
    }

}

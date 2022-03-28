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

    Student student1, student2, student3, student4, student5, student6;
    Parent parent1, parent2, parent3;
    Teacher teacher1,teacher2, teacher3;
    Subject subject1, subject2, subject3, subject4, subject5;
    @Test
    void saveDataTest() {
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

        //parent1.getStudents().add(student1);
        //parent1.getStudents().add(student6);
        student1.setParent(parent1);
        student6.setParent(parent1);
        //parent2.getStudents().add(student2);
        //parent2.getStudents().add(student4);
        student2.setParent(parent2);
        student4.setParent(parent2);
        //parent3.getStudents().add(student3);
        //parent3.getStudents().add(student5);
        student3.setParent(parent3);
        student5.setParent(parent3);

        student1.getSubjects().add(subject1);
        student1.getSubjects().add(subject2);
        student2.getSubjects().add(subject3);
        student2.getSubjects().add(subject5);
        student3.getSubjects().add(subject4);
        student4.getSubjects().add(subject5);
        student5.getSubjects().add(subject2);
        student6.getSubjects().add(subject3);

        subject1.getStudents().add(student1);
        subject2.getStudents().add(student1);
        subject2.getStudents().add(student5);
        subject3.getStudents().add(student2);
        subject3.getStudents().add(student6);
        subject4.getStudents().add(student3);
        subject5.getStudents().add(student4);

        student1.getTeachers().add(teacher1);
        student2.getTeachers().add(teacher2);
        student2.getTeachers().add(teacher3);
        student3.getTeachers().add(teacher1);
        student4.getTeachers().add(teacher2);
        student5.getTeachers().add(teacher1);
        student6.getTeachers().add(teacher3);

        teacher1.getStudents().add(student1);
        teacher1.getStudents().add(student3);
        teacher1.getStudents().add(student5);
        teacher2.getStudents().add(student2);
        teacher2.getStudents().add(student4);
        teacher3.getStudents().add(student2);
        teacher3.getStudents().add(student6);

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
}

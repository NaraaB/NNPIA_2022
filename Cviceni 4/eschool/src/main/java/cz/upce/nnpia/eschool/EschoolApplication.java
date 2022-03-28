package cz.upce.nnpia.eschool;

import cz.upce.nnpia.eschool.entity.Student;
import cz.upce.nnpia.eschool.entity.Teacher;
import cz.upce.nnpia.eschool.repository.StudentRepository;
import cz.upce.nnpia.eschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(EschoolApplication.class, args);
    }

}

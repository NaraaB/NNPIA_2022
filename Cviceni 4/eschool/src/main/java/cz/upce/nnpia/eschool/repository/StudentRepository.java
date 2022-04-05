package cz.upce.nnpia.eschool.repository;

import cz.upce.nnpia.eschool.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Student findStudentByNameContains(String contains);
    //List<Student> findStudentByIdBetween(Integer start, Integer end);
}

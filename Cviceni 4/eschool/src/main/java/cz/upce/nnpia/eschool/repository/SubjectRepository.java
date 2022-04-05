package cz.upce.nnpia.eschool.repository;

import cz.upce.nnpia.eschool.entity.Subject;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findSubjectsBySubjectNameContains(String contains);
    @Query(" select s from Subject s where s.id between 1 and 2")
    List<Subject> findSubjectsByIdBetween(Integer start, Integer end);
}

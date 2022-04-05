package cz.upce.nnpia.eschool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    //(name = "parent_name", referencedColumnName = "parentName")
    private Parent parent;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Subject> subjects = new HashSet<>();

    @Column(length = 50)
    private String studentName;

    @Column(length = 20)
    private String major;

    @Column()
    private Integer year;

    @Column()
    private Float gpa;

    @Column()
    private String email;

    public Student(){}

    public Student(String name, String major, Integer year){
        this.studentName = name;
        this.major = major;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //relationship related methods
    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }
}

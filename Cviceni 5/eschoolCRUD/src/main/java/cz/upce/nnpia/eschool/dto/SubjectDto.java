package cz.upce.nnpia.eschool.dto;

import cz.upce.nnpia.eschool.entity.Teacher;

public class SubjectDto {
    private Integer id;
    private String subjectName;
    private Teacher teacher;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Integer getTeacherID() {
        return teacher.getId();
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

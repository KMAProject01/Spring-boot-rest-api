package net.java.student.Entity;




import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "MaLop")
    private String MaLop;
    @Column(name = "STT")
    private Integer STT;

    @Column(name = "Teacher_master")
    private String Teacher_master;


    @ManyToOne
    @JoinColumn(name = "schoolyear_id")
    private SchoolYear schoolYear;

    @ManyToOne
    @JoinColumn(name = "studyProgram_id")
    private StudyProgram studyProgram;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "aClass",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Student> students;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public Integer getSTT() {
        return STT;
    }

    public void setSTT(Integer STT) {
        this.STT = STT;
    }

    public String getTeacher_master() {
        return Teacher_master;
    }

    public void setTeacher_master(String teacher_master) {
        Teacher_master = teacher_master;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudyProgram getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

package net.java.student.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "StudyProgram")
public class StudyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name_program")
    private String name_program;


    @JsonIgnore
    @OneToMany(mappedBy = "studyProgram",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Class> classes;

    @JsonIgnore
    @OneToMany(mappedBy = "studyProgram",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Subject> subjects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_program() {
        return name_program;
    }

    public void setName_program(String name_program) {
        this.name_program = name_program;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}

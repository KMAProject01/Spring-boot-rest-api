package net.java.student.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "Organize_year")
    private Integer Organize_year;


//    @OneToOne(mappedBy = "department")
//    private Teacher teacher;

//    @OneToOne(mappedBy = "department1")
//    private Subject subject;


        @OneToMany(targetEntity = Subject.class,cascade = CascadeType.ALL)
        @JoinColumn(name = "subject_id",referencedColumnName = "id")
        private List<Subject> subjects;







    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganize_year() {
        return Organize_year;
    }

    public void setOrganize_year(Integer organize_year) {
        Organize_year = organize_year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}

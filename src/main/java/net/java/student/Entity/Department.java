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

    @JsonIgnore
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Class> aClass;

    @JsonIgnore
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Subject> subject;







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

    public List<Class> getaClass() {
        return aClass;
    }

    public void setaClass(List<Class> aClass) {
        this.aClass = aClass;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

}

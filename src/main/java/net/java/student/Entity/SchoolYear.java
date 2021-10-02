package net.java.student.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SchoolYear")
public class SchoolYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "yearStart")
    private Integer yearStart;
    @Column(name = "yearEnd")
    private Integer yearEnd;

    @JsonIgnore
    @OneToMany(mappedBy = "schoolYear",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Class> aClass;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearStart() {
        return yearStart;
    }

    public void setYearStart(Integer yearStart) {
        this.yearStart = yearStart;
    }

    public Integer getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Integer yearEnd) {
        this.yearEnd = yearEnd;
    }

    public List<Class> getaClass() {
        return aClass;
    }

    public void setaClass(List<Class> aClass) {
        this.aClass = aClass;
    }
}

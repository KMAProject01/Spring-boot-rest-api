package net.java.student.Entity;

import javax.persistence.*;
import java.util.Date;

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

    @OneToOne(mappedBy = "schoolYear")
    private Class aClass;



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
}

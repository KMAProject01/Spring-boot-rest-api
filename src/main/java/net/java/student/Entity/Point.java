package net.java.student.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "diem1")
    private Float diem1;
    @Column(name = "diem2")
    private Float diem2;
    @Column(name = "diemKTHp")
    private Float diemKTHp;

    @JsonIgnore
    @OneToOne(mappedBy = "point")
    private Subject subject;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getDiem1() {
        return diem1;
    }

    public void setDiem1(Float diem1) {
        this.diem1 = diem1;
    }

    public Float getDiem2() {
        return diem2;
    }

    public void setDiem2(Float diem2) {
        this.diem2 = diem2;
    }

    public Float getDiemKTHp() {
        return diemKTHp;
    }

    public void setDiemKTHp(Float diemKTHp) {
        this.diemKTHp = diemKTHp;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}

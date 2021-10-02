package net.java.student.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Subject_list")
public class SubjectList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "semester")
    private Integer Semester;
    @Column(name = "Ma_mon")
    private String Ma_mon;
    @Column(name = "So_tin_chi")
    private Integer So_tin_chi;
    @Column(name = "tiet_thuc_hanh")
    private Integer Tiet_thuc_hanh;
    @Column(name = "tiet_ly_thuyet")
    private Integer Tiet_ly_thuyet;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "point_id")
    private Point point;

    @OneToMany(mappedBy = "subjectList",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Schedule> schedule;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSemester() {
        return Semester;
    }

    public void setSemester(Integer semester) {
        Semester = semester;
    }

    public String getMa_mon() {
        return Ma_mon;
    }

    public void setMa_mon(String ma_mon) {
        Ma_mon = ma_mon;
    }

    public Integer getSo_tin_chi() {
        return So_tin_chi;
    }

    public void setSo_tin_chi(Integer so_tin_chi) {
        So_tin_chi = so_tin_chi;
    }

    public Integer getTiet_thuc_hanh() {
        return Tiet_thuc_hanh;
    }

    public void setTiet_thuc_hanh(Integer tiet_thuc_hanh) {
        Tiet_thuc_hanh = tiet_thuc_hanh;
    }

    public Integer getTiet_ly_thuyet() {
        return Tiet_ly_thuyet;
    }

    public void setTiet_ly_thuyet(Integer tiet_ly_thuyet) {
        Tiet_ly_thuyet = tiet_ly_thuyet;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}

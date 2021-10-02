package net.java.student.Service;

import net.java.student.Entity.Class;
import net.java.student.Entity.Point;
import net.java.student.Repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointRepository repository;

    //show  duoi dang json
    public List<Point> list(){
        return repository.findAll();
    }

    //them  vao table
    public Point save(Point point){
        return repository.save(point);
    }

    //lay  theo dang sinh vien
    public Point get(Integer id){
        return repository.findById(id).get();
    }

    //xoa  theo id
    public void delete(Integer id){
        repository.deleteById(id);
    }
}

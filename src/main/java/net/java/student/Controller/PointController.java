package net.java.student.Controller;


import net.java.student.Entity.Point;
import net.java.student.Service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/logins")
public class PointController {

    @Autowired
    private PointService service;


    @GetMapping("/points")
    public List<Point> list(){
        return service.list();
    }

    @PostMapping("/points")
    public Point Cresubjects(@Valid @RequestBody Point point){
        return service.save(point);
    }

    @GetMapping("/points/{id}")
    public ResponseEntity<Point> getByID(@PathVariable(value = "id") Integer id){
        try{
            Point point = service.get(id);
            return new ResponseEntity<Point>(point, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Point>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/points/{id}")
    public ResponseEntity<?> Update(@RequestBody Point point,@PathVariable(value = "id") Integer id){
        try {
            Point SetPoint = service.get(id);
            SetPoint.setDiem1(point.getDiem1());
            SetPoint.setDiem2(point.getDiem2());
            SetPoint.setDiemKTHp(point.getDiemKTHp());
            service.save(SetPoint);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/points/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

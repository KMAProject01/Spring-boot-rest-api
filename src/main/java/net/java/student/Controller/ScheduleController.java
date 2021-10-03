package net.java.student.Controller;

import net.java.student.Entity.LoginStudent;
import net.java.student.Entity.Schedule;
import net.java.student.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/logins/students")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @GetMapping("/schedules")
    public List<Schedule> list(){
        return service.list();

    }

    @PostMapping("/schedules")
    public Schedule CreLoginStudent(@Valid @RequestBody Schedule schedule){
        return service.save(schedule);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<Schedule> getByID(@PathVariable(value = "id") Integer id){
        try{
            Schedule schedule = service.get(id);
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<?> Update(@RequestBody Schedule schedule, @PathVariable(value = "id") Integer id){
        try {
            Schedule SetSchedule = service.get(id);
            SetSchedule.setPosition(schedule.getPosition());
            SetSchedule.setDate(schedule.getDate());
            service.save(SetSchedule);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

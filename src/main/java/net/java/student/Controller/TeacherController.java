package net.java.student.Controller;

import net.java.student.Entity.SubjectList;
import net.java.student.Entity.Teacher;
import net.java.student.Repository.TeacherRepository;
import net.java.student.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/logins")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @Autowired
    private TeacherRepository repository;

    @GetMapping("/teachers")
    public List<Teacher> list(){
        return service.list();
    }

    @PostMapping("/teachers")
    public Teacher CreTeacher(@Valid @RequestBody Teacher teacher){
        return service.save(teacher);
    }


    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> getByID(@PathVariable(value = "id") Integer id){
        try{
            Teacher teacher = service.get(id);
            return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<?> Update(@RequestBody Teacher teacher,@PathVariable(value = "id") Integer id){
        try {
            Teacher SetTeacher = service.get(id);
            SetTeacher.setName(teacher.getName());
            SetTeacher.setPhone(teacher.getPhone());
            service.save(SetTeacher);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

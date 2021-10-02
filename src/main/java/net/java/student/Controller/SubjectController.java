package net.java.student.Controller;

import net.java.student.Entity.Subject;
import net.java.student.Entity.SubjectList;
import net.java.student.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/logins")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping("/subjects")
    public List<Subject> list(){
        return service.list();

    }

    @PostMapping("/subjects")
    public Subject CreSubject(@Valid @RequestBody Subject subject){
        return service.save(subject);
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getByID(@PathVariable(value = "id") Integer id){
        try{
            Subject subject = service.get(id);
            return new ResponseEntity<Subject>(subject,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/subjects/{id}")
    public ResponseEntity<?> Update(@RequestBody Subject subject, @PathVariable(value = "id") Integer id){
        try {
            Subject SetSubject = service.get(id);
            SetSubject.setName(subject.getName());
            SetSubject.setDateTest(subject.getDateTest());
            service.save(SetSubject);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

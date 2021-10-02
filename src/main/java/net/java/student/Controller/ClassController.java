package net.java.student.Controller;


import net.java.student.Entity.Class;
import net.java.student.Entity.Student;
import net.java.student.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
@RequestMapping("/api/logins/students")
public class ClassController {

    @Autowired
    private ClassService service;


    @GetMapping("/classes")
    public List<Class> list(){
        return service.list();
    }

    @PostMapping("/classes")
    public Class CreAClass(@Valid @RequestBody Class aClass){
        return service.save(aClass);
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity<Class> getByID(@PathVariable(value = "id") Integer id){
        try{
            Class aClass = service.get(id);
            return new ResponseEntity<Class>(aClass, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Class>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/classes/{id}")
    public ResponseEntity<?> Update(@RequestBody Class aClass,@PathVariable(value = "id") Integer id){
        try {
            Class SetClass = service.get(id);
            SetClass.setMaLop(aClass.getMaLop());
            SetClass.setSTT(aClass.getSTT());
            service.save(aClass);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/classes/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}


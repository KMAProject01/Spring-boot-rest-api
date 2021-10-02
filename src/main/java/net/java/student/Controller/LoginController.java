package net.java.student.Controller;


import net.java.student.Entity.LoginStudent;
import net.java.student.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/logins")
    public List<LoginStudent> list(){
        return service.list();

    }

    @PostMapping("/logins")
    public LoginStudent CreLoginStudent(@Valid @RequestBody LoginStudent loginStudent){
        return service.save(loginStudent);
    }

    @GetMapping("/logins/{id}")
    public ResponseEntity<LoginStudent> getByID(@PathVariable(value = "id") Integer id){
        try{
            LoginStudent loginStudent = service.get(id);
            return new ResponseEntity<LoginStudent>(loginStudent,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<LoginStudent>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/logins/{id}")
    public ResponseEntity<?> Update(@RequestBody LoginStudent loginStudent,@PathVariable(value = "id") Integer id){
        try {
            LoginStudent SetloginStudent = service.get(id);
            SetloginStudent.setMaSV(loginStudent.getMaSV());
            SetloginStudent.setPassWord(loginStudent.getPassWord());
            service.save(SetloginStudent);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/logins/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}

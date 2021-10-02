package net.java.student.Controller;


import net.java.student.Entity.Class;
import net.java.student.Entity.Department;
import net.java.student.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/logins")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/departments")
    public List<Department> list(){
        return service.list();
    }

    @PostMapping("/departments")
    public Department CreDepartment(@Valid @RequestBody Department department){
        return service.save(department);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getByID(@PathVariable(value = "id") Integer id){
        try{
            Department department = service.get(id);
            return new ResponseEntity<Department>(department, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<?> Update(@RequestBody Department department,@PathVariable(value = "id") Integer id){
        try {
            Department SetDepartment = service.get(id);
            SetDepartment.setName(department.getName());
            SetDepartment.setName(department.getName());
            service.save(SetDepartment);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

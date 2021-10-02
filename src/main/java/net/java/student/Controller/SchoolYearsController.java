package net.java.student.Controller;

import net.java.student.Entity.SchoolYear;

import net.java.student.Service.SchoolYearsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/logins")
public class SchoolYearsController {

    @Autowired
    private SchoolYearsService service;

    @GetMapping("/schoolyears")
    public List<SchoolYear> List(){
        return service.list();
    }

    @PostMapping("/schoolyears")
    public SchoolYear CreSchoolYear(@RequestBody SchoolYear schoolYear){
        return service.save(schoolYear);
    }
    @GetMapping("/schoolyears/{id}")
    public ResponseEntity<SchoolYear> getByID(@PathVariable(value = "id") Integer id){
        try {
            SchoolYear schoolYear = service.get(id);
            return new ResponseEntity<SchoolYear>(schoolYear, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<SchoolYear>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/schoolyears/{id}")
    public ResponseEntity<?> Update(@RequestBody SchoolYear schoolYear,@PathVariable(value = "id") Integer id){
        try {
            SchoolYear SetSchoolYear = service.get(id);
            SetSchoolYear.setYearStart(schoolYear.getYearStart());
            SetSchoolYear.setYearEnd(schoolYear.getYearEnd());
            service.save(SetSchoolYear);
            return new ResponseEntity<SchoolYear>(schoolYear, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<SchoolYear>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/schoolyears/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

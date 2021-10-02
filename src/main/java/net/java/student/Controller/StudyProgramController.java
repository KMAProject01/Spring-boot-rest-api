package net.java.student.Controller;

import net.java.student.Entity.Student;
import net.java.student.Entity.StudyProgram;
import net.java.student.Service.StudyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/logins")
public class StudyProgramController {

    @Autowired
    private StudyProgramService service;


    @GetMapping("/studyPrograms")
    public List<StudyProgram> list(){

        return service.list();
    }

    @PostMapping("/studyPrograms")
    public StudyProgram CreStudent(@Valid @RequestBody StudyProgram studyProgram){
        return service.save(studyProgram);
    }

    @GetMapping("/studyPrograms/{id}")
    public ResponseEntity<StudyProgram> getByID(@PathVariable(value = "id") Integer id){
        try{
             StudyProgram studyProgram = service.get(id);
            return new ResponseEntity<StudyProgram>(studyProgram, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<StudyProgram>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/studyPrograms/{id}")
    public ResponseEntity<?> Update(@RequestBody StudyProgram studyProgram,@PathVariable(value = "id") Integer id){
        try {
            StudyProgram SetStudyProgram = service.get(id);
            SetStudyProgram.setName_program(studyProgram.getName_program());
            service.save(SetStudyProgram);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/studyPrograms/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

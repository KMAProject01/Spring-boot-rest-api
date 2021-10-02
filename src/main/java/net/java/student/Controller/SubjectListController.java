package net.java.student.Controller;


import net.java.student.Entity.LoginStudent;
import net.java.student.Entity.SubjectList;
import net.java.student.Repository.SubjectListRepository;
import net.java.student.Service.LoginService;
import net.java.student.Service.SubjectListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/logins")
public class SubjectListController {

    @Autowired
    private SubjectListService service;


    @GetMapping("/subjectLists")
    public List<SubjectList> list(){
        return service.list();

    }

    @PostMapping("/subjectLists")
    public SubjectList CreSubjectList(@Valid @RequestBody SubjectList subjectList){
        return service.save(subjectList);
    }

    @GetMapping("/subjectLists/{id}")
    public ResponseEntity<SubjectList> getByID(@PathVariable(value = "id") Integer id){
        try{
            SubjectList subjectList = service.get(id);
            return new ResponseEntity<SubjectList>(subjectList,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<SubjectList>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/subjectLists/{id}")
    public ResponseEntity<?> Update(@RequestBody SubjectList subjectlist,@PathVariable(value = "id") Integer id){
        try {
            SubjectList SetsubjectList = service.get(id);
            SetsubjectList.setMa_mon(subjectlist.getMa_mon());
            SetsubjectList.setSemester(subjectlist.getSemester());
            SetsubjectList.setSo_tin_chi(subjectlist.getSo_tin_chi());
            SetsubjectList.setTiet_thuc_hanh(subjectlist.getTiet_thuc_hanh());
            SetsubjectList.setTiet_ly_thuyet(subjectlist.getTiet_ly_thuyet());
            service.save(SetsubjectList);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/subjectLists/{id}")
    public ResponseEntity<?> Delete(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}

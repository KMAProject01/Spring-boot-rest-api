package net.java.student.Service;

import net.java.student.Entity.Subject;
import net.java.student.Entity.Teacher;
import net.java.student.Repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectsRepository repository;

    public List<Subject> list(){
        return repository.findAll();
    }

    //them sinh vien vao table
    public Subject save(Subject subject){
        return repository.save(subject);
    }

    //lay student theo dang sinh vien
    public Subject get(Integer id){
        return repository.findById(id).get();
    }


    //xoa sinh vien theo id
    public void delete(Integer id){
        repository.deleteById(id);
    }


}

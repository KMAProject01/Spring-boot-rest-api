package net.java.student.Service;


import net.java.student.Entity.Class;
import net.java.student.Entity.Student;
import net.java.student.Repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository repository;

    //show  duoi dang json
    public List<Class> list(){
        return repository.findAll();
    }

    //them  vao table
    public Class save(Class aClass){
        return repository.save(aClass);
    }

    //lay  theo dang sinh vien
    public Class get(Integer id){
        return repository.findById(id).get();
    }

    //xoa  theo id
    public void delete(Integer id){
        repository.deleteById(id);
    }
}

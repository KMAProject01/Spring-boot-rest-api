package net.java.student.Service;

import net.java.student.Entity.Student;
import net.java.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {

    @Autowired
    private StudentRepository repository;


    //show student duoi dang json
    
    public List<Student> list(){
        return repository.findAll();
    }



    //them sinh vien vao table
    public Student save(Student student){
       return repository.save(student);
    }

    //lay student theo dang sinh vien
    public Student get(Integer id){
        return repository.findById(id).get();
    }


    //xoa sinh vien theo id
    public void delete(Integer id){
        repository.deleteById(id);
    }

}
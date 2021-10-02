package net.java.student.Service;

import net.java.student.Entity.LoginStudent;
import net.java.student.Entity.Teacher;
import net.java.student.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

   public List<Teacher> list(){
       return repository.findAll();
   }

    //them sinh vien vao table
    public Teacher save(Teacher teacher){
        return repository.save(teacher);
    }

    //lay student theo dang sinh vien
    public Teacher get(Integer id){
        return repository.findById(id).get();
    }


    //xoa sinh vien theo id
    public void delete(Integer id){
        repository.deleteById(id);
    }
}

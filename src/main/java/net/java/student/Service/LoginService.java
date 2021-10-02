package net.java.student.Service;


import jdk.management.resource.ResourceRequestDeniedException;
import net.java.student.Entity.LoginStudent;
import net.java.student.Entity.Student;
import net.java.student.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    public List<LoginStudent> list(){
        return repository.findAll();
    }

    //them sinh vien vao table
    public LoginStudent save(LoginStudent loginStudent){
        return repository.save(loginStudent);
    }

    //lay student theo dang sinh vien
    public LoginStudent get(Integer id){
        return repository.findById(id).get();
    }


    //xoa sinh vien theo id
    public void delete(Integer id){
        repository.deleteById(id);
    }
}

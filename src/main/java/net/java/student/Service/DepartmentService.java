package net.java.student.Service;

import net.java.student.Entity.Class;
import net.java.student.Entity.Department;
import net.java.student.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    //show  duoi dang json
    public List<Department> list(){
        return repository.findAll();
    }

    //them  vao table
    public Department save(Department department){
        return repository.save(department);
    }

    //lay  theo dang sinh vien
    public Department get(Integer id){
        return repository.findById(id).get();
    }

    //xoa  theo id
    public void delete(Integer id){
        repository.deleteById(id);
    }
}

package net.java.student.Service;

import net.java.student.Entity.SchoolYear;
import net.java.student.Repository.SchoolYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolYearsService {

    @Autowired
    private SchoolYearRepository repository;

    public List<SchoolYear> list(){
        return repository.findAll();
    }

    public SchoolYear save(SchoolYear schoolYear){
        return repository.save(schoolYear);
    }

    public SchoolYear get(Integer id){
        return repository.findById(id).get();
    }

    public void delete(Integer  id){
        repository.deleteById(id);
    }
}

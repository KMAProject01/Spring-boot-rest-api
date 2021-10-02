package net.java.student.Service;

import net.java.student.Entity.LoginStudent;
import net.java.student.Entity.SubjectList;
import net.java.student.Repository.SubjectListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectListService {

    @Autowired
    private SubjectListRepository subjectListRepository;

    public List<SubjectList> list(){
        return subjectListRepository.findAll();
    }

    public SubjectList save(SubjectList subjectList){
        return subjectListRepository.save(subjectList);
    }

    public SubjectList get(Integer id){
        return subjectListRepository.findById(id).get();
    }

    public void delete(Integer id){
        subjectListRepository.deleteById(id);
    }
}

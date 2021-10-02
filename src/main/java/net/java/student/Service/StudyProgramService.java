package net.java.student.Service;

import net.java.student.Entity.Class;
import net.java.student.Entity.StudyProgram;
import net.java.student.Repository.StudyProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramService {

    @Autowired
    private StudyProgramRepository repository;

    //show  duoi dang json
    public List<StudyProgram> list(){
        return repository.findAll();
    }

    //them  vao table
    public StudyProgram save(StudyProgram studyProgram){
        return repository.save(studyProgram);
    }

    //lay  theo dang sinh vien
    public StudyProgram get(Integer id){
        return repository.findById(id).get();
    }

    //xoa  theo id
    public void delete(Integer id){
        repository.deleteById(id);
    }

}

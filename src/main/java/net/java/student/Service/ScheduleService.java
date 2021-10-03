package net.java.student.Service;

import net.java.student.Entity.LoginStudent;
import net.java.student.Entity.Schedule;
import net.java.student.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    public List<Schedule> list(){
        return repository.findAll();
    }

    //them sinh vien vao table
    public Schedule save(Schedule schedule){
        return repository.save(schedule);
    }

    //lay student theo dang sinh vien
    public Schedule get(Integer id){
        return repository.findById(id).get();
    }


    //xoa sinh vien theo id
    public void delete(Integer id){
        repository.deleteById(id);
    }
}

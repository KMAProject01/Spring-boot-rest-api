package net.java.student.Repository;

import net.java.student.Entity.SubjectList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectListRepository extends JpaRepository<SubjectList, Integer> {
}

package net.java.student.Repository;

import net.java.student.Entity.LoginStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface LoginRepository extends JpaRepository<LoginStudent, Integer> {
}

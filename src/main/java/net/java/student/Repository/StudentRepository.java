package net.java.student.Repository;


import io.dropwizard.servlets.assets.ResourceNotFoundException;
import net.java.student.Entity.Student;
import org.apache.tomcat.jni.User;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.nio.file.attribute.UserPrincipal;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}

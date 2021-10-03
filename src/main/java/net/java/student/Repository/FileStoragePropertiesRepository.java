package net.java.student.Repository;

import net.java.student.Entity.FileStorageProperties;
import net.java.student.Exception.FileStorageException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStoragePropertiesRepository extends JpaRepository<FileStorageProperties,Integer> {



    @Query("Select a from FileStorageProperties a where id = ?1 and file_type = ?2")
    FileStorageProperties checkFileByUserId(Integer userId, String docType);

    @Query("Select fileName from FileStorageProperties a where user_id = ?1 and file_type = ?2")
    String getUploadFilePath(Integer userId, String docType);
}

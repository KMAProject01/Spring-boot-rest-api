package net.java.student.Entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;

@ConfigurationProperties(prefix = "file")
@Entity
@Table(name = "file")
public class FileStorageProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String FileType;

    @Column(name = "file_fomat")
    private String FileFomat;

    @Column(name = "upload_dir")
    private String upload_Dir;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return FileType;
    }

    public void setFileType(String fileType) {
        FileType = fileType;
    }

    public String getFileFomat() {
        return FileFomat;
    }

    public void setFileFomat(String fileFomat) {
        FileFomat = fileFomat;
    }

    public String getUpload_Dir() {
        return upload_Dir;
    }

    public void setUpload_Dir(String upload_Dir) {
        this.upload_Dir = upload_Dir;
    }


}

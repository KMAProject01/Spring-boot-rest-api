package net.java.student.Service;

import net.java.student.Entity.FileStorageProperties;
import net.java.student.Exception.FileStorageException;
import net.java.student.Repository.FileStoragePropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    private FileStoragePropertiesRepository repository;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties){
          this.fileStorageLocation = Paths.get(fileStorageProperties.getUpload_Dir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        }catch (Exception ex){
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }

    }

    public String storeFile(MultipartFile file,Integer id,String FileType){

        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName = "";

        try {

            // Check if the file's name contains invalid characters

            if(originalFileName.contains("..")) {

                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + originalFileName);
            }
            String fileExtension = "";
            try {
                fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            } catch(Exception e) {
                fileExtension = "";
            }
            fileName = id + "_" + FileType + fileExtension;

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(),targetLocation,StandardCopyOption.REPLACE_EXISTING);

            FileStorageProperties properties = repository.checkFileByUserId(id,FileType);

            if (properties != null){
                properties.setFileFomat(file.getContentType());
                properties.setFileName(fileName);
                repository.save(properties);
            }else {
                FileStorageProperties newProperties = new FileStorageProperties();
                newProperties.setId(id);
                newProperties.setFileFomat(file.getContentType());
                newProperties.setFileName(fileName);
                newProperties.setFileType(FileType);
                repository.save(newProperties);
            }
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

    }

    public Resource loadFileAsResource(String fileName) throws Exception {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }

        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName);
        }

    }


    public String getFileName(Integer id, String FileType) {

        return repository.getUploadFilePath(id, FileType);

    }



}

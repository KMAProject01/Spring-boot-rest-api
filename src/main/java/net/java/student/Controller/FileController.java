package net.java.student.Controller;

import net.java.student.PayLoad.UploadFileResponse;
import net.java.student.Service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
     public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id, @RequestParam("file_type") String FileType) {

        String fileName = fileStorageService.storeFile(file, id, FileType);


        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString();


        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());

    }

    @GetMapping("/downloadFile")

    public ResponseEntity<Resource> downloadFile(@RequestParam("id") Integer id,

                                                 @RequestParam("file_type") String FileType,

                                                 HttpServletRequest request) {



        String fileName = fileStorageService.getFileName(id, FileType);

        Resource resource = null;

        if(fileName !=null && !fileName.isEmpty()) {

            try {

                resource = fileStorageService.loadFileAsResource(fileName);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Try to determine file's content type

            String contentType = null;

            try {

                contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

            } catch (IOException ex) {

                //logger.info("Could not determine file type.");

            }

            // Fallback to the default content type if type could not be determined

            if(contentType == null) {

                contentType = "application/octet-stream";

            }

            return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);

        } else {

            return ResponseEntity.notFound().build();
        }

    }
}

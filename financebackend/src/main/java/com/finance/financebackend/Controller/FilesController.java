package com.finance.financebackend.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.finance.financebackend.Beans.FilesUploadDownload;
import com.finance.financebackend.Service.FileUploadDownloadService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Files")
public class FilesController {
	private static final Logger logger = LoggerFactory.getLogger(FilesController.class);

    @Autowired
    private FileUploadDownloadService fileUploadDownloadService;

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FilesUploadDownload uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileUploadDownloadService.uploadFile(file);

        return new FilesUploadDownload(fileName);
    }
    
  //http://localhost:8282/Files/getFiles
    // Displays the list of uploaded files.
    @GetMapping("/getFiles")
    public List<String> getFiles() throws IOException {
        return fileUploadDownloadService.getFiles();
    }

  //http://localhost:8282/Files/downloadFile
    // Downloads a file using filename.
    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws MalformedURLException {
        Resource resource = fileUploadDownloadService.loadFileAsResource(fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}

package marketplace.backend.service;

import org.springframework.web.multipart.MultipartFile;

import marketplace.backend.model.File;

public interface FileService {

    public File add(MultipartFile file);
    
    public File findById(Long id);
}

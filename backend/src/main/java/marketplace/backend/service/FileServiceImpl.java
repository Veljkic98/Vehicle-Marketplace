package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import marketplace.backend.exception.exceptions.file.ImageBadRequestException;
import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.model.File;
import marketplace.backend.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public File add(MultipartFile file) {
        
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            File fileDB = new File(fileName, file.getContentType(), file.getBytes());

            return fileRepository.save(fileDB);
        } catch (Exception e) {
            throw new ImageBadRequestException();
        }
    }

    @Override
    public File findById(Long id) {
        
        File file;

        if ((file = fileRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("File", id);

        return file;
    }

    public void remove(Long id) {

        if (fileRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("File", id);

        fileRepository.deleteById(id);
    }

}

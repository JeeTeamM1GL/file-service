package com.booking.fileservice.services;

import com.booking.fileservice.UploadFileResponse;
import com.booking.fileservice.core.utils.IDGenerate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Service
public class FileServiceImpl implements IFileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public UploadFileResponse uploadFile(MultipartFile file) {
        try {
            var id = IDGenerate.generate("IMG");
            Path filePath = Paths.get(uploadDir, id);
            Files.copy(file.getInputStream(), filePath);

            UploadFileResponse uploadFileResponse = new UploadFileResponse();
            uploadFileResponse.setFileId(id);
            uploadFileResponse.setFileType(file.getContentType());
            return uploadFileResponse;
        } catch (IOException e) {
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}

package com.booking.fileservice.services;

import com.booking.fileservice.UploadFileResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    UploadFileResponse uploadFile(MultipartFile file);
}

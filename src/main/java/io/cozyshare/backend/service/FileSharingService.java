package io.cozyshare.backend.service;

import io.cozyshare.backend.model.SharedFile;
import io.cozyshare.backend.repository.SharedFileRepository;
import io.cozyshare.backend.resource.SharedFileResource;
import io.cozyshare.backend.resource.SharedFileReturnResource;
import io.cozyshare.backend.adapter.outbound.AWSPresignedURLClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.Optional;

@Service
public class FileSharingService {

    @Autowired
    private SharedFileRepository fileRepository;

    @Autowired
    private AWSPresignedURLClient generatePresignedURLService;

    @Autowired
    private QRImageGenerateService qrImageGenerateService;

    @Autowired
    private FileNumberService fileNumberService;

    private final String FILE_SHARING_URL = "http://localhost:8080/redirect/file/";

    private final String FILE_SHARING_ERROR_URL = "http://localhost:8080/error";

    public SharedFileReturnResource shareFile(SharedFileResource sharedFileResource) throws Exception {
        int fileNumber = fileNumberService.generateFileNumber();
        SharedFile savedFile = fileRepository.save(sharedFileResource.toFileModel(fileNumber));

        String sharingUrl = FILE_SHARING_URL + savedFile.getUuid();
        BufferedImage sharingQRImage = qrImageGenerateService.generateQRCodeImage(sharingUrl);

        return new SharedFileReturnResource(sharingUrl, sharingQRImage, fileNumber);
    }


    public String getFileURLForUuid(String uuid) {
        Optional<SharedFile> byFileKey = fileRepository.findByUuid(uuid);
        if(byFileKey.isPresent()){
            SharedFile sharedFile = byFileKey.get();
            if (sharedFile.getRedirectUrl() != null){
                return sharedFile.getRedirectUrl();
            }
            String presignedURL = generatePresignedURLService.generatePresignedURL(sharedFile.getFileKey());
            sharedFile.setRedirectUrl(presignedURL);
            fileRepository.save(sharedFile);
            return presignedURL;
        }
        return null;
    }

    public ResponseEntity<Void> getRedirectUrlFromFileNumber(int fileNumber) {
        Optional<SharedFile> byFileNumber = fileRepository.findByFileNumber(fileNumber);
        if(byFileNumber.isPresent()){
            SharedFile sharedFile = byFileNumber.get();
            return redirectForFile(sharedFile.getUuid());
        }
        throw new RuntimeException("Can't find the file from number.");
    }

    public ResponseEntity<Void> redirectForFile(String uuid) {
        String fileURLForKey = getFileURLForUuid(uuid);
        if (fileURLForKey != null) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(fileURLForKey)).build();
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(FILE_SHARING_ERROR_URL)).build();
        }
    }
}

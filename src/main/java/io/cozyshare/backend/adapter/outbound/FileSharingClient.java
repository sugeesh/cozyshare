package io.cozyshare.backend.adapter.outbound;

import io.cozyshare.backend.model.SharedFile;
import io.cozyshare.backend.repository.SharedFileRepository;
import io.cozyshare.backend.resource.SharedFileResource;
import io.cozyshare.backend.resource.SharedFileReturnResource;
import io.cozyshare.backend.service.GeneratePresignedURLService;
import io.cozyshare.backend.service.QRImageGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Optional;

@Service
public class FileSharingClient {

    @Autowired
    private SharedFileRepository fileRepository;

    @Autowired
    private GeneratePresignedURLService generatePresignedURLService;

    @Autowired
    private QRImageGenerateService qrImageGenerateService;

    private final String FILE_SHARING_URL = "http://localhost:8080/redirect/file/";

    public SharedFileReturnResource shareFile(SharedFileResource sharedFileResource) throws Exception {
        SharedFile savedFile = fileRepository.save(sharedFileResource.toFileModel());
        String sharingUrl = FILE_SHARING_URL + savedFile.getFileKey();
        BufferedImage sharingQRImage = qrImageGenerateService.generateQRCodeImage(sharingUrl);
        return new SharedFileReturnResource(sharingUrl, sharingQRImage);
    }


    public String getFileURLForKey(String fileKey) {
        Optional<SharedFile> byFileKey = fileRepository.findByFileKey(fileKey);
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
}

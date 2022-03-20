package io.cozyshare.backend.adapter.inbound;

import io.cozyshare.backend.adapter.outbound.FileSharingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/redirect")
public class RedirectController {

    @Autowired
    private FileSharingClient fileSharingService;

    private final String FILE_SHARING_ERROR_URL = "http://localhost:8080/error";

    @GetMapping("/file/{file_key}")
    public ResponseEntity<Void> redirectForFile(@PathVariable(value = "file_key") String fileKey) {
        String fileURLForKey = fileSharingService.getFileURLForKey(fileKey);
        if(fileURLForKey != null) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(fileURLForKey)).build();
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(FILE_SHARING_ERROR_URL)).build();
        }
    }
}

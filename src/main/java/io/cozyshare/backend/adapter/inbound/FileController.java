package io.cozyshare.backend.adapter.inbound;

import io.cozyshare.backend.resource.SharedFileResource;
import io.cozyshare.backend.resource.SharedFileReturnResource;
import io.cozyshare.backend.service.FileSharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileSharingService fileSharingService;

    @PostMapping()
    @CrossOrigin("*")
    public SharedFileReturnResource shareFile(@RequestBody SharedFileResource sharedFileResource) throws Exception {
        return fileSharingService.shareFile(sharedFileResource);
    }

    @GetMapping("/number/{file_number}")
    @CrossOrigin("*")
    public ResponseEntity<Void> getRedirectUrlFromFileNumber(@PathVariable("file_number") int fileNumber) throws Exception {
        return fileSharingService.getRedirectUrlFromFileNumber(fileNumber);
    }


}

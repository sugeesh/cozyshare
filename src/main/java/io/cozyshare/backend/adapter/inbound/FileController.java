package io.cozyshare.backend.adapter.inbound;

import io.cozyshare.backend.resource.SharedFileResource;
import io.cozyshare.backend.resource.SharedFileReturnResource;
import io.cozyshare.backend.adapter.outbound.FileSharingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileSharingClient fileSharingService;

    @PostMapping("/share")
    public SharedFileReturnResource shareFile(@RequestBody SharedFileResource sharedFileResource) throws Exception {
        return fileSharingService.shareFile(sharedFileResource);
    }


}

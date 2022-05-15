package io.cozyshare.backend.adapter.inbound;

import io.cozyshare.backend.service.FileSharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redirect")
public class RedirectController {

    @Autowired
    private FileSharingService fileSharingService;

    @GetMapping("/file/{uuid}")
    @CrossOrigin("*")
    public ResponseEntity<Void> redirectForFile(@PathVariable(value = "uuid") String uuid) {
        return fileSharingService.redirectForFile(uuid);
    }
}

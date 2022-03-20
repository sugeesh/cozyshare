package io.cozyshare.backend.adapter.inbound;

import io.cozyshare.backend.service.FileSharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redirect")
public class RedirectController {

    @Autowired
    private FileSharingService fileSharingService;

    @GetMapping("/file/{uuid}")
    public ResponseEntity<Void> redirectForFile(@PathVariable(value = "uuid") String uuid) {
        return fileSharingService.redirectForFile(uuid);
    }
}

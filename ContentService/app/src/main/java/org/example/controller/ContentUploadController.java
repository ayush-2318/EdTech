package org.example.controller;

import org.example.exception.ContentUploadException;
import org.example.request.ContentUploadRequest;
import org.example.service.ContentUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentUploadController {
    @Autowired
    private ContentUploadService contentUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadContent(@RequestBody ContentUploadRequest contentUploadRequest){
        contentUploadService.uploadContent(contentUploadRequest);
        return new ResponseEntity<String>("Uploaded",HttpStatus.OK);
    }
}

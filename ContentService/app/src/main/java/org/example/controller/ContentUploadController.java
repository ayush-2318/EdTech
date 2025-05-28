package org.example.controller;

import org.example.dto.RetriveDto;
import org.example.request.ContentUploadRequest;
import org.example.service.ContentRetriveService;
import org.example.service.ContentUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentUploadController {
    @Autowired
    private ContentUploadService contentUploadService;

    @Autowired
    private ContentRetriveService contentRetriveService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadContent(@RequestBody ContentUploadRequest contentUploadRequest){
        contentUploadService.uploadContent(contentUploadRequest);
        return new ResponseEntity<String>("Uploaded",HttpStatus.OK);
    }


}

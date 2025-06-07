package org.example.controller;

import org.example.request.QuizUploadRequest;
import org.example.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadQuiz(@RequestBody QuizUploadRequest quizUploadRequest){
        quizService.uploadQuiz(quizUploadRequest);
        return new ResponseEntity<String>("uploaded", HttpStatus.OK);
    }
}

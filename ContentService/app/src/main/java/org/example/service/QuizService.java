package org.example.service;

import org.example.entities.ClassEntity;
import org.example.entities.QuizEntity;
import org.example.exception.ContentUploadException;
import org.example.repository.ClassRepo;
import org.example.repository.QuizRepo;
import org.example.request.QuizUploadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {
    @Autowired
    private ClassRepo classRepo;

    @Autowired
    private QuizRepo quizRepo;

    // upload quiz to db
    public void uploadQuiz(QuizUploadRequest quizUploadRequest){
        ClassEntity classEntity=classRepo.findByName(quizUploadRequest.getClassName())
                .orElseGet(()->classRepo.save(new ClassEntity(quizUploadRequest.getClassName())));
        try {
            quizSaveTODB(quizUploadRequest,classEntity);
        }catch (Exception e){
            throw new  ContentUploadException("Not able to upload the quiz");
        }
    }

    private void quizSaveTODB(QuizUploadRequest quizUploadRequest,ClassEntity classEntity){
        List<QuizEntity> quizEntityList = new ArrayList<>();

        for(Map.Entry<LocalDate,List<String>> entry:quizUploadRequest.getQuiz()
                .entrySet()){
            LocalDate date=entry.getKey();
            for(String question:entry.getValue()){
                QuizEntity quizEntity=QuizEntity.builder()
                        .questionText(question)
                        .quizTitle(quizUploadRequest.getQuizTitle())
                        .scheduledDate(date)
                        .scheduledTime(LocalTime.of(10,0))
                        .classEntity(classEntity).build();

                quizEntityList.add(quizEntity);
            }
        }
        quizRepo.saveAll(quizEntityList);
    }
}

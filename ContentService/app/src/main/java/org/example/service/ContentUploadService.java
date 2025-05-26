package org.example.service;

import jakarta.transaction.Transactional;
import org.example.entities.*;
import org.example.exception.ContentUploadException;
import org.example.repository.*;
import org.example.request.ContentUploadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentUploadService {
    @Autowired
    private ClassRepo classRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private ChapterRepo chapterRepo;
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    ContentRepo contentRepo;

    @Transactional
    public void uploadContent(ContentUploadRequest request) {
        try{
            ClassEntity classEntity = classRepo.findByName(request.getClassName())
                    .orElseGet(() -> classRepo.save(new ClassEntity(request.getClassName())));

            SubjectEntity subjectEntity=subjectRepo.findByNameAndClassEntity(request.getSubjectName(), classEntity)
                    .orElseGet(()->subjectRepo.save(new SubjectEntity(request.getSubjectName(),classEntity)));

            ChapterEntity chapterEntity=chapterRepo.findByNameAndSubjectEntity(request.getChapterName(), subjectEntity)
                    .orElseGet(()->chapterRepo.save(new ChapterEntity(request.getChapterName(),subjectEntity)));
            TopicEntity topicEntity=topicRepo.findByNameAndChapterEntity(request.getTopicName(), chapterEntity)
                    .orElseGet(()->topicRepo.save(new TopicEntity(request.getTopicName(), chapterEntity)));
            ContentEntity contentEntity=new ContentEntity(request.getContentTitle(), request.getContent(), topicEntity);

            contentRepo.save(contentEntity);
        } catch (RuntimeException e) {
            throw new ContentUploadException("Not able to upload the content");
        }

    }
}

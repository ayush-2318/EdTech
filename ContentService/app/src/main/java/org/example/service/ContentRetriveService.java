package org.example.service;

import org.example.dto.ContentDto;
import org.example.dto.RetriveDto;
import org.example.entities.ContentEntity;
import org.example.exception.ContentRetriveException;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentRetriveService {
    @Autowired
    private ClassRepo classRepo;
    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private ChapterRepo chapterRepo;

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private ContentRepo contentRepo;


    public List<RetriveDto> getSubjectFromClass(Long classId){
        List<RetriveDto> subjectList =subjectRepo.findSubjectsById(classId);
        if (subjectList.isEmpty()){
            throw  new ContentRetriveException("Subject not found");
        }
        return subjectList;
    }

    public List<RetriveDto> getChapterFromSubject(Long subjectId){
        List<RetriveDto> chapterList=chapterRepo.findChapterById(subjectId);
        if(chapterList.isEmpty()){
            throw new ContentRetriveException("Chapter not found");
        }
        return chapterList;
    }

    public List<RetriveDto>getTopicFromChapter(Long chapterId){
        List<RetriveDto> topicList= topicRepo.findTopicById(chapterId);
        if(topicList.isEmpty()){
            throw new ContentRetriveException("Topic not found");
        }
        return topicList;
    }



    public List<ContentDto> getContetnFromTopic(Long topicId){
        List<ContentDto> content=contentRepo.findContentById(topicId);
        if(content.isEmpty()){
            throw new ContentRetriveException("Content not found");
        }
        return content;
    }


}

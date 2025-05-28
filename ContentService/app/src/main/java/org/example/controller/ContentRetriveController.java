package org.example.controller;

import org.example.dto.ContentDto;
import org.example.dto.RetriveDto;
import org.example.service.ContentRetriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentRetriveController {
    @Autowired
    ContentRetriveService contentRetriveService;

    // controller to get subject list
    @GetMapping("/{classId}/subject")
    public List<RetriveDto> getsubject(@PathVariable Long classId){
        return contentRetriveService.getSubjectFromClass(classId);

    }

    // controller to get chapter list
    @GetMapping("/{subjectId}/chapter")
    public List<RetriveDto> getChapter(@PathVariable Long subjectId){
        List<RetriveDto> chapterList=contentRetriveService.getChapterFromSubject(subjectId);
        return  chapterList;
    }

    // controller to get topic list
    @GetMapping("/{chapterId}/topic")
    public List<RetriveDto> getTopic(@PathVariable Long chapterId){
        return contentRetriveService.getTopicFromChapter(chapterId);
    }



    // controller to get content
    @GetMapping("/{topicId}/content")
    public List<ContentDto> getContent(@PathVariable Long topicId){
        return contentRetriveService.getContetnFromTopic(topicId);
    }


}

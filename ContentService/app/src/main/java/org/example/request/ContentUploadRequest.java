package org.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentUploadRequest {
    @JsonProperty("className")
    private String className;
    @JsonProperty("subjectName")
    private String subjectName;
    @JsonProperty("chapterName")
    private String chapterName;
    @JsonProperty("topicName")
    private String topicName;
    @JsonProperty("content")
    private String content;
    @JsonProperty("contentTitle")
    private String contentTitle;
}

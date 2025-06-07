package org.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizUploadRequest {
    @JsonProperty("className")
    private String className;
    @JsonProperty("quizTitle")
    private String quizTitle;
    @JsonProperty("quiz")
    private Map<LocalDate, List<String>> quiz;
}

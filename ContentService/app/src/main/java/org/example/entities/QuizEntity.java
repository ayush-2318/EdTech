package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "quiz")
@Builder
public class QuizEntity {
    @Id
    @GeneratedValue
    private  Long id;

    private String questionText;

    private String quizTitle;

    private LocalDate scheduledDate;

    private LocalTime scheduledTime;

    private boolean isVisible=false;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

}

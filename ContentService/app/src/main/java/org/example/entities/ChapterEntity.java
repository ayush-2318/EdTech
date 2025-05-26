package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "chapter")
public class ChapterEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private SubjectEntity subjectEntity;

    @OneToMany(mappedBy = "chapterEntity",cascade = CascadeType.ALL)
    private List<TopicEntity> topic;

    public ChapterEntity(String name,SubjectEntity subjectEntity){
        this.name=name;
        this.subjectEntity=subjectEntity;
    }

}

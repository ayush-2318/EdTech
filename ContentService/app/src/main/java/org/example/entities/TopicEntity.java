package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.repository.TopicRepo;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="topic")
public class TopicEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private ChapterEntity chapterEntity;

    @OneToMany(mappedBy = "topicEntity",cascade = CascadeType.ALL)
    private List<ContentEntity> contentEntity;

    public TopicEntity(String name,ChapterEntity chapterEntity){
        this.name=name;
        this.chapterEntity=chapterEntity;
    }

}

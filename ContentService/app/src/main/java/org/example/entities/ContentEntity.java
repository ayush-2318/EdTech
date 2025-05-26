package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "content")
public class ContentEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String contentBody;
    @ManyToOne
    private TopicEntity topicEntity;

    public ContentEntity(String title,String contentBody,TopicEntity topicEntity){
        this.title=title;
        this.contentBody=contentBody;
        this.topicEntity=topicEntity;

    }

}

package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="subject")
public class SubjectEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private ClassEntity classEntity;

    @OneToMany(mappedBy = "subjectEntity",cascade = CascadeType.ALL)
    private List<ChapterEntity> chapter;

    public SubjectEntity(String name,ClassEntity classEntity){
        this.name =name;
        this.classEntity=classEntity;
    }
}

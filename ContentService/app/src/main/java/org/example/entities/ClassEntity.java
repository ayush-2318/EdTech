package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.security.auth.Subject;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="class")
public class ClassEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "classEntity",cascade = CascadeType.ALL)
    private List<SubjectEntity> subjects;

    public ClassEntity(String name){
        this.name=name;
    }
}

package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public interface ContentDto {
    Long getId();
    String getTitle();
    String getContentBody();
}

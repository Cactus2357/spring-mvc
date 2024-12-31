package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Club {
    Integer id;
    String title;
    String photoUrl;
    String content;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}

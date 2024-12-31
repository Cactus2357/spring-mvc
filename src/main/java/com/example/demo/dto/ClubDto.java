package com.example.demo.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClubDto {
    Integer id;
    String title;
    String photoUrl;
    String content;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}

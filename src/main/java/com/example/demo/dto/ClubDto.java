package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Club title should not be empty")
    String title;
    @NotEmpty(message = "Photo link should not be empty")
    String photoUrl;
    @NotEmpty(message = "Content should not be empty")
    String content;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}

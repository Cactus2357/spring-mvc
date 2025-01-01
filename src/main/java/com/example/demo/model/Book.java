package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    Integer bookId;
    String title;
    String author;
    int quantity;
}

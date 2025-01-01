package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Borrowing {
    int borrowId;
    int memberId;
    int bookId;
    LocalDateTime borrowDate;
    LocalDateTime returnDate;
    String status;
}

package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {
    Integer memberId;
    String name;
    String email;
    LocalDateTime joinDate;
    String membershipType;
}

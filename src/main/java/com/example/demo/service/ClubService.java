package com.example.demo.service;

import com.example.demo.dto.ClubDto;

import java.util.List;
import java.util.Optional;

public interface ClubService {
    List<ClubDto> getClubs();
    Optional<List<ClubDto>> getClubsByTitle(String query);
    void save(ClubDto club);
    ClubDto findClubById(int clubId);
    void updateClub(ClubDto club);
    void deleteClubById(int clubId);
}

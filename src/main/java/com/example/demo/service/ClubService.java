package com.example.demo.service;

import com.example.demo.dto.ClubDto;
import com.example.demo.model.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> getClubs();
    Club save(Club club);
    ClubDto findClubById(int clubId);
    void updateClub(Club club);
}

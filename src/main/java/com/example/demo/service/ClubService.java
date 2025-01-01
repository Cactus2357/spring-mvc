package com.example.demo.service;

import com.example.demo.dto.ClubDto;
import com.example.demo.model.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> getClubs();
    void save(ClubDto club);
    ClubDto findClubById(int clubId);
    void updateClub(ClubDto club);

}

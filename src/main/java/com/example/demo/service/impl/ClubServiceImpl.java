package com.example.demo.service.impl;

import com.example.demo.dto.ClubDto;
import com.example.demo.mapper.ClubMapper;
import com.example.demo.model.Club;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubMapper clubMapper;

    @Autowired
    public ClubServiceImpl(ClubMapper clubMapper) {
        this.clubMapper = clubMapper;
    }

    @Override
    public List<ClubDto> getClubs() {
        List<Club> clubList = clubMapper.findAll();
        return clubList.stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    @Override
    public Club save(Club club) {
        int newClubId = clubMapper.save(club);
        return clubMapper.findById(newClubId);
    }

    @Override
    public ClubDto findClubById(int clubId) {
        Club club = clubMapper.findById(clubId);
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(Club club) {
        clubMapper.update(club);
    }


    private ClubDto mapToClubDto(Club club) {
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
    }
}

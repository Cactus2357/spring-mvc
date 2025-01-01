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
    public void save(ClubDto clubDto) {
        clubMapper.save(mapToClub(clubDto));
    }

    @Override
    public ClubDto findClubById(int clubId) {
        Club club = clubMapper.findById(clubId);
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        clubMapper.update(mapToClub(clubDto));
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

    private Club mapToClub(ClubDto club) {
        return Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
    }
}

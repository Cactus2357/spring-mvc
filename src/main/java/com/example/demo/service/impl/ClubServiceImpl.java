package com.example.demo.service.impl;

import com.example.demo.dto.ClubDto;
import com.example.demo.mapper.ClubMapper;
import com.example.demo.model.Club;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
    public Optional<List<ClubDto>> getClubsByTitle(String query) {
        List<String> queryArray = Arrays.asList(query.split("\\s+"));

        List<Club> filteredClubs = clubMapper.findAll()
                .stream()
                .filter(club -> queryArray.stream()
                        .anyMatch(queryPart -> club.getTitle().toLowerCase().contains(queryPart.toLowerCase())))
                .toList();

        return Optional.of(filteredClubs.stream()
                .map(this::mapToClubDto)
                .toList());
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

    @Override
    public void deleteClubById(int clubId) {
        clubMapper.delete(clubId);
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

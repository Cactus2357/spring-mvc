package com.example.demo.mapper;

import com.example.demo.model.Club;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubMapper {

    @Select("select * from clubs")
    List<Club> findAll();
}

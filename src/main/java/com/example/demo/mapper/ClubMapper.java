package com.example.demo.mapper;

import com.example.demo.model.Club;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubMapper {

    @Select("select * from clubs")
    List<Club> findAll();


    @Insert("INSERT INTO clubs (id, name, location) VALUES (#{id}, #{name}, #{location}) " +
            "ON DUPLICATE KEY UPDATE name = #{name}, location = #{location}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Club club);

    @Select("select * from clubs where id = #{id}")
    Club findById(int id);
}

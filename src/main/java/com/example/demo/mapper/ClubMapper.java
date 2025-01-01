package com.example.demo.mapper;

import com.example.demo.model.Club;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ClubMapper {

    @Select("select * from demo.clubs")
    List<Club> findAll();

    @Select("""
                SELECT * 
                FROM demo.clubs 
                WHERE title IN 
                <foreach collection="titles" item="title" open="(" separator="," close=")">
                    #{title}
                </foreach>
            """)
    Optional<List<Club>> findByTitle(@Param("titles") List<String> titles);


    @Insert("INSERT INTO demo.clubs (title, photoUrl, content) VALUES (#{title}, #{photoUrl}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Club club);

    @Select("select * from demo.clubs where id = #{id}")
    Club findById(int id);

    @Update("update demo.clubs set title = #{title}, photoUrl = #{photoUrl}, content = #{content} where id = #{id}")
    void update(Club club);

    @Delete("delete from demo.clubs where id = #{id}")
    void delete(int id);
}

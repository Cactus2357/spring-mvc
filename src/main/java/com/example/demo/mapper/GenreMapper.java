package com.example.demo.mapper;

import com.example.demo.model.Genre;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GenreMapper {
    @Select("select * from bookdb.genres")
    List<Genre> findAll();

    @Select("select * from bookdb.genres where genre_id = #{genreId}")
    Genre findById(Integer genreId);

    @Insert("insert into bookdb.genres (genre_name) values (#{genreName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Genre genre);

    @Update("update bookdb.genres set genre_name = #{genreName} where genre_id = #{genreId}")
    void update(Genre genre);

    @Delete("delete from bookdb.genres where genre_id = #{genreId}")
    void delete(int genreId);


}

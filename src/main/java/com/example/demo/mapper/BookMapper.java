package com.example.demo.mapper;

import com.example.demo.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from bookdb.books")
    List<Book> findAll();

    @Select("select * from bookdb.books where book_id = #{id}")
    Book findById(Integer id);

    @Insert("insert into bookdb.books (title, author, quantity) values (#{title}, #{author}, #{quantity})")
    Book save(Book book);

    @Update("update bookdb.books set title = #{title}, author = #{author}, quantity = #{quantity} where book_id = #{bookId}")
    Book update(Book book);

    @Delete("delete from bookdb.books where book_id = #{bookId}")
    void delete(Integer bookId);
}

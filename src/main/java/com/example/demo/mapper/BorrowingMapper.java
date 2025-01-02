package com.example.demo.mapper;

import com.example.demo.model.Borrowing;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BorrowingMapper {
    @Select("select * from bookdb.borrowing ORDER BY borrow_date DESC")
    List<Borrowing> findAll();

    @Select("select * from bookdb.borrowing where borrow_id = #{borrowId}")
    Borrowing findById(int borrowId);

    @Select("SELECT COUNT(b1.book_id) < (SELECT quantity FROM bookdb.books WHERE book_id = #{bookId}) FROM bookdb.borrowing b1 WHERE b1.book_id = #{bookId}")
    boolean isBookAvailable(int bookId);

    @Insert("insert into bookdb.borrowing (member_id, book_id, borrow_date) values (#{memberId}, #{bookId}, #{borrowDate})")
    @Options(useGeneratedKeys = true, keyProperty = "borrowId")
    int insert(Borrowing book);

    @Update("update bookdb.borrowing set return_date = NOW(), status = 'returned' where borrow_id = #{borrowId} and status = 'borrowed'")
    void update(int borrowId);
}

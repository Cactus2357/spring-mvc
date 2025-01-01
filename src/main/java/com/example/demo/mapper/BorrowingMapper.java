package com.example.demo.mapper;

import com.example.demo.model.Borrowing;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BorrowingMapper {
    @Select("select * from bookdb.borrowing")
    List<Borrowing> findAll();

    @Select("select * from bookdb.borrowing where borrow_id = #{borrowId}")
    Borrowing findById(int borrowId);

    @Insert("insert into bookdb.borrowing (member_id, book_id, borrow_date) values (#{memberId}, #{bookId}, #{borrowDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Borrowing book);

    @Update("update bookdb.borrowing set return_date = NOW(), status = 'returned' where borrow_id = #{borrowId} and status = 'borrowed'")
    void update(Borrowing borrowing);
}

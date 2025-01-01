package com.example.demo.mapper;

import com.example.demo.model.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("select * from bookdb.members")
    List<Member> findAll();

    @Select("select * from bookdb.members where member_id = #{memberId}")
    Member findById(int memberId);

    @Insert("insert into bookdb.members (name, email, membership_type) values (#{name}, #{email}, #{membershipType})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Member member);

    @Update("update bookdb.members set name = #{name}, email = #{email}, membership_type = #{membershipType} where member_id = #{memberId}")
    void update(Member member);

//    @Delete("delete from bookdb.members where member_id = #{memberId}")
//    void delete(int memberId);

}

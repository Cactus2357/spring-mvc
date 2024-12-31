package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users")
    List<User> findAll();

    @Select("select * from users where name like #{name}")
    List<User> findByName(String name);

    @Insert("insert into users(name, salary) values (#{name}, #{salary})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(User user);


    @Update("update users set salary = #{salary} where name = #{name}")
    void update(User user);

    @Delete("delete from users where name = #{name}")
    void delete(User user);
}

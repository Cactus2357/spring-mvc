package com.example.demo.resource;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserMapper userMapper;

    public UserResource(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    @GetMapping("/add")
    public List<User> update() {

        User user = new User();
        user.setName("New user");
        user.setSalary(2333L);

        userMapper.insert(user);

        return userMapper.findAll();
    }

    @GetMapping("/update")
    public List<User> updateUsers() {
        User user = new User();
        user.setName("New user 2");
        user.setSalary(2333L);

        userMapper.update(user);
        return userMapper.findAll();
    }

    @GetMapping("/delete")
    public List<User> deleteUsers() {
        User user = new User();
        user.setName("New user");

        userMapper.delete(user);
        return userMapper.findAll();
    }
}

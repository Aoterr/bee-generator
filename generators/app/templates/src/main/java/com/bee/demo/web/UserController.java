package com.bee.demo.web;

import com.bee.demo.entity.User;
import com.bee.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by guos on 2018/11/4
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserRepository userRepository;


    @GetMapping("list")
    public List<User> getById() {
        List<User> users = userRepository.findAll();
        return users;
    }
}

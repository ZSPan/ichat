package com.ichat.controller;

import com.ichat.dao.UserRepository;
import com.ichat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*
    * 查询所有女生列表
    * @return
    * */
    @GetMapping(value = "/users")
    public List<User> userList() {
        return userRepository.findAll();
    }

    //添加用户
    @PostMapping(value = "/users")
    public User userAdd(@RequestParam("account") String account,
                        @RequestParam("password") String password) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        return userRepository.save(user);
    }

    //查询一个用户
    @GetMapping(value = "/users/{id}")
    public User userFindOne(@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }

    //更新
    @PutMapping(value = "/users/{id}")
    public User userUpdate(@PathVariable("id") Integer id,
                           @RequestParam("account") String account,
                           @RequestParam("password") String password) {
        User user = new User();
        user.setId(id);
        user.setAccount(account);
        user.setPassword(password);
        return userRepository.save(user);
    }

    //删除
    @DeleteMapping(value = "/users/{id}")
    public void userDelete(@PathVariable("id") Integer id) {
        userRepository.delete(id);
    }

}

package com.aioria.service.impl;

import com.aioria.domain.User;
import com.aioria.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(Long id) throws Exception {
        if(id==3) {
            throw new Exception("查询不到此用户");
        }
        Supplier<User> supplier =  User::new;
        User user= supplier.get();
        user.setId(id);
        user.setName("张三");
        user.setAge(23);
        user.setSalary(500.00);
        log.info("获取User对象,["+user+"]");
        return user;
    }


    public List<User> filter(Predicate<User> predicate, List<User> users) throws Exception {
        List<User> newUsers = new ArrayList<>();
        for(User user:users) {
            if(predicate.test(user)) {
                newUsers.add(user);
            }
        }
        return newUsers;
    }
}

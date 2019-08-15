package com.aioria.controller;

import com.aioria.domain.User;
import com.aioria.msg.ObjectRestResponse;
import com.aioria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ObjectRestResponse getUser(@PathVariable Long id) throws Exception{
        ObjectRestResponse restResponse = new ObjectRestResponse();
        User user = userService.getUser(id);
        restResponse.data(user).rel(true);
        return restResponse;
    }


}

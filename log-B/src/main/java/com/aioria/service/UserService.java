package com.aioria.service;

import com.aioria.domain.User;

import java.util.List;
import java.util.function.Predicate;

public interface UserService {
    public User getUser(Long id) throws  Exception;
    public List<User> filter(Predicate<User> predicate, List<User> users) throws Exception;
}

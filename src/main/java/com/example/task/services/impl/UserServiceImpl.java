package com.example.task.services.impl;

import com.example.task.entity.Color;
import com.example.task.entity.User;
import com.example.task.repositories.UserRepository;
import com.example.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersWhereAgeBiger(int age) {
        return userRepository.findByAgeGreaterThan(age);
    }

    @Override
    public List<User> getUsersByColor(Color color) {
        return userRepository.findByArticles_colorIs(color);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<String> findByArticlesCount(int count) {

        List<User> users = userRepository.findAll();
        users= users.stream().filter(user -> user.getArticles().size() > count).collect(Collectors.toList());
        List<String>list=new ArrayList<>();
        for (User user:users){
            list.add(user.getName());
        }
        return list.stream().distinct().collect(Collectors.toList());
    }


}

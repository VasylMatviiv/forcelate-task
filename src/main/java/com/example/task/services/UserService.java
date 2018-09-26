package com.example.task.services;

import com.example.task.entity.Color;
import com.example.task.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Optional<User> getUser(long id);
    public List<User> getAll();
    public List<User> getUsersWhereAgeBiger(int age);
    public List<User> getUsersByColor(Color color);
    public User save(User user);
    public List<String> findByArticlesCount(int count );
}

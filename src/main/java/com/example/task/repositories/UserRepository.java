package com.example.task.repositories;

import com.example.task.entity.Color;
import com.example.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByAgeGreaterThan(int age);

    public List<User> findByArticles_colorIs(Color color);


}

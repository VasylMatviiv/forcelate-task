package com.example.task.repositories;

import com.example.task.entity.Color;
import com.example.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByAgeGreaterThan(int age);

    public List<User> findByArticles_colorIs(Color color);

    @Query("select distinct u.name from User u  join u.articles a group by u.name having count(u.name)> :numb")
    public List<String> findUsersByArticlesMoreThenThree(Long numb);


}

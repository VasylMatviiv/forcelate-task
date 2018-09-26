package com.example.task.controllers;

import com.example.task.entity.Color;
import com.example.task.entity.Article;
import com.example.task.entity.User;
import com.example.task.services.ArticleService;
import com.example.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getAll();
    }

    @GetMapping("/users/age")
    public List<User> getUsersByAgeGreaterThan(@RequestParam int age) {
        return userService.getUsersWhereAgeBiger(age);
    }

    @GetMapping("/users/color")
    public List<User> getUsersByColorInArticle(@RequestParam String color) {

        return userService.getUsersByColor(Color.valueOf(color.toUpperCase()));
    }

    @GetMapping("/users/articles")
    public List<String> getByArticles_lengthGreaterThen() {

        return userService.findByArticlesCount(3);
    }

    @GetMapping("/articles")
    public List<Article> getAllArticle() {
        return articleService.getAll();
    }

    @PostMapping("/articles")

    public ResponseEntity createArticle(@RequestBody Article article) {
        articleService.save(article);
        return new ResponseEntity(article, HttpStatus.OK);

    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
